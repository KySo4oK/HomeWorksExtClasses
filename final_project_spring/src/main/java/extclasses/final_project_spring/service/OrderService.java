package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Order;
import extclasses.final_project_spring.entity.Shelf;
import extclasses.final_project_spring.entity.User;
import extclasses.final_project_spring.exception.BookNotFoundException;
import extclasses.final_project_spring.exception.OrderNotFoundException;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.OrderRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import extclasses.final_project_spring.repository.UserRepository;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final ShelfRepository shelfRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, BookRepository bookRepository, ShelfRepository shelfRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.shelfRepository = shelfRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public boolean createOrder(BookDTO bookDTO, String userName) {
        Book book = bookRepository.findById(bookDTO.getId())
                .orElseThrow(() -> new BookNotFoundException("book - " + bookDTO.getName() + " not exist"));
        Order order = new Order();//todo builder
        book.addOrder(order);
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User - " + userName + " not exist"));
        order.setUser(user);
        orderRepository.save(order);
        return true;
    }

    @Transactional(rollbackFor = OrderNotFoundException.class)
    public void permitOrder(OrderDTO orderDTO) {
        Order order = orderRepository
                .findById(orderDTO.getId())
                .orElseThrow(() -> new OrderNotFoundException("Active order - " + orderDTO.getBookName() +
                        " - " + orderDTO.getUserName() + " not exist"));
        order.setActive(true);
        order.setStartDate(LocalDate.now());
        order.setEndDate(LocalDate.now().plusMonths(1));
        orderRepository.save(order);
    }

    public Set<OrderDTO> getActiveOrders() {
        return orderRepository
                .findAllByActiveIsTrue()
                .stream()
                .map(x -> new OrderDTO(x, LocaleContextHolder.getLocale().equals(Locale.US)))
                .collect(Collectors.toSet());
    }

    public Set<OrderDTO> getPassiveOrders() {
        return orderRepository.findAllByActiveIsFalse()
                .stream()
                .map(x -> new OrderDTO(x, LocaleContextHolder.getLocale().equals(Locale.US)))
                .collect(Collectors.toSet());
    }

    public Set<OrderDTO> getActiveOrdersByUserName(String name) {
        return orderRepository.findAllByActiveIsTrueAndUser_Username(name)
                .stream()
                .map(x -> new OrderDTO(x, LocaleContextHolder.getLocale().equals(Locale.US)))
                .collect(Collectors.toSet());
    }

    public Set<OrderDTO> getPassiveOrdersByUserName(String name) {
        return orderRepository.findAllByActiveIsFalseAndUser_Username(name)
                .stream()
                .map(x -> new OrderDTO(x, LocaleContextHolder.getLocale().equals(Locale.US)))
                .collect(Collectors.toSet());
    }

    @Transactional(rollbackFor = {BookNotFoundException.class, OrderNotFoundException.class})
    public void returnBook(OrderDTO orderDTO) {
        Book book = LocaleContextHolder.getLocale().equals(Locale.US) ? bookRepository
                .findByName(orderDTO.getBookName())
                .orElseThrow(() -> new BookNotFoundException("book not exist")) :
        bookRepository
                .findByName(orderDTO.getBookName())
                .orElseThrow(() -> new BookNotFoundException("book not exist"));
        Order order = orderRepository
                .findById(orderDTO.getId())
                .orElseThrow(() -> new OrderNotFoundException("order not exist"));
        book.setUser(null);
        book.removeOrder(order);
        book.setShelf(shelfRepository.findByBookIsNull().orElse(new Shelf()));
        bookRepository.save(book);
        orderRepository.delete(order);
    }
}
