package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Order;
import extclasses.final_project_spring.entity.Shelf;
import extclasses.final_project_spring.exception.BookNotAvailableException;
import extclasses.final_project_spring.exception.BookNotFoundException;
import extclasses.final_project_spring.exception.OrderNotFoundException;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.OrderRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import extclasses.final_project_spring.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Component
public class OrderService {
    private static final int PERIOD_OF_USE = 1;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final ShelfRepository shelfRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        BookRepository bookRepository,
                        ShelfRepository shelfRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.shelfRepository = shelfRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createOrder(BookDTO bookDTO, String username) {
        orderRepository.save(Order.builder()
                .user(userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not exist")))
                .book(bookRepository.findById(bookDTO.getId())
                        .orElseThrow(() -> new BookNotFoundException("book not exist")))
                .active(false)
                .endDate(LocalDate.now())
                .startDate(LocalDate.now())
                .build());
    }

    @Transactional(rollbackFor = OrderNotFoundException.class)
    public void permitOrder(OrderDTO orderDTO) {
        log.info("permit order {}", orderDTO);
        Order order = orderRepository
                .findById(orderDTO.getId())
                .orElseThrow(() -> new OrderNotFoundException("Active order not exist"));
        if (!order.getBook().isAvailable()) throw new BookNotAvailableException("Book not available");
        order.setActive(true);
        order.setStartDate(LocalDate.now());
        order.setEndDate(LocalDate.now().plusMonths(PERIOD_OF_USE));
        order.getBook().setUser(order.getUser());
        order.getBook().setAvailable(false);
        orderRepository.save(order);
    }

    public Set<OrderDTO> getActiveOrders() {
        return orderRepository
                .findAllByActiveIsTrue()
                .stream()
                .map(this::buildOrderDTO)
                .collect(Collectors.toSet());
    }

    public Set<OrderDTO> getPassiveOrders() {
        return orderRepository.findAllByActiveIsFalse()
                .stream()
                .map(this::buildOrderDTO)
                .collect(Collectors.toSet());
    }

    public Set<OrderDTO> getActiveOrdersByUserName(String name) {
        log.info("active orders by username {}", name);
        return orderRepository.findAllByActiveIsTrueAndUser_Username(name)
                .stream()
                .map(this::buildOrderDTO)
                .collect(Collectors.toSet());
    }

    private OrderDTO buildOrderDTO(Order order) {
        return OrderDTO.builder()
                .bookName(getBookNameByLocale(order))
                .id(order.getOrderId())
                .userName(order.getUser().getUsername())
                .endDate(order.getEndDate()
                        .format(getFormatterByLocale()))
                .startDate(order.getStartDate()
                        .format(getFormatterByLocale()))
                .build();
    }

    private String getBookNameByLocale(Order order) {
        return LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
                order.getBook().getName() : order.getBook().getNameUa();
    }

    private DateTimeFormatter getFormatterByLocale() {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .withLocale(LocaleContextHolder.getLocale());
    }

    public Set<OrderDTO> getPassiveOrdersByUserName(String name) {
        log.info("passive orders by username {}", name);
        return orderRepository.findAllByActiveIsFalseAndUser_Username(name)
                .stream()
                .map(this::buildOrderDTO)
                .collect(Collectors.toSet());
    }

    @Transactional(rollbackFor = {BookNotFoundException.class, OrderNotFoundException.class})
    public void returnBook(OrderDTO orderDTO) {
        log.info("return book {}", orderDTO.getBookName());
        Book book = getByNameAndLocale(orderDTO.getBookName())
                .orElseThrow(() -> new BookNotFoundException("book not exist"));
        Order order = orderRepository
                .findById(orderDTO.getId())
                .orElseThrow(() -> new OrderNotFoundException("order not exist"));
        book.setUser(null);
        book.setAvailable(true);
        book.removeOrder(order);
        book.setShelf(shelfRepository.findByBookIsNull().orElse(new Shelf()));
        bookRepository.save(book);
        orderRepository.delete(order);
    }

    private Optional<Book> getByNameAndLocale(String name) {
        return LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
                bookRepository.findByName(name) : bookRepository
                .findByNameUa(name);
    }
}
