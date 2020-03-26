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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Component
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean createOrder(BookDTO bookDTO, String userName) {
        Book book = bookRepository.findByName(bookDTO.getName())
                .orElseThrow(() -> new BookNotFoundException("book - " + bookDTO.getName() + " not exist"));
        Order order = new Order();
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
                .findByActiveFalseAndBook_NameAndUser_Username(orderDTO.getBookName(), orderDTO.getUserName())
                .orElseThrow(() -> new OrderNotFoundException("Active order - " + orderDTO.getBookName() +
                        " - " + orderDTO.getUserName() + " not exist"));
        order.setActive(true);
        order.setStartDate(LocalDate.now());
        order.setEndDate(LocalDate.now().plusMonths(1));
        orderRepository.save(order);
    }

    public Set<Order> getActiveOrders() {
        return orderRepository.findAllByActiveIsTrue();
    }

    public Set<Order> getPassiveOrders() {
        return orderRepository.findAllByActiveIsFalse();
    }

    public Set<Order> getActiveOrdersByUserName(String name) {
        return orderRepository.findAllByActiveIsTrueAndUser_Username(name);
    }

    public Set<Order> getPassiveOrdersByUserName(String name) {
        return orderRepository.findAllByActiveIsFalseAndUser_Username(name);
    }

    @Transactional(rollbackFor = {BookNotFoundException.class, OrderNotFoundException.class})
    public void returnBook(OrderDTO orderDTO) {
        Book book = bookRepository
                .findByName(orderDTO.getBookName())
                .orElseThrow(() -> new BookNotFoundException("book - " + orderDTO.getBookName() + " not exist"));
        Order order = orderRepository
                .findByActiveTrueAndBook_NameAndUser_Username(
                        orderDTO.getBookName(),
                        orderDTO.getUserName())
                .orElseThrow(() -> new OrderNotFoundException("order - " + orderDTO.getBookName() +
                        " - " + orderDTO.getUserName() + " not exist"));
        book.setUser(null);
        book.removeOrder(order);
        book.setShelf(shelfRepository.findByBookIsNull().orElse(new Shelf()));
        bookRepository.save(book);
        orderRepository.delete(order);
    }
}
