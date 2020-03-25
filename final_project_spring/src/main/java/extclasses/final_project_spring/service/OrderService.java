package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Order;
import extclasses.final_project_spring.entity.User;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.OrderRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import extclasses.final_project_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
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

    public boolean createOrder(BookDTO bookDTO, String userName) throws Exception {
        Optional<Book> bookOptional = bookRepository.findByName(bookDTO.getName());
        if (bookOptional.isEmpty()) return false;
        Book book = bookOptional.get();
        Order order = new Order();
        book.addOrder(order);
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new Exception("No user with this username"));
        order.setUser(user);
        orderRepository.save(order);
        return true;
    }

    public void permitOrder(OrderDTO orderDTO) throws Exception {
        Order order = orderRepository
                .findByActiveFalseAndBook_NameAndUser_Username(orderDTO.getBookName(), orderDTO.getUserName())
                .orElseThrow(() -> new Exception("cannot permit order"));
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

    public void returnBook(OrderDTO orderDTO, Authentication authentication) throws Exception {
        Book book = bookRepository
                .findByName(orderDTO.getBookName())
                .orElseThrow(() -> new Exception("no book"));
        Order order = orderRepository
                .findByActiveTrueAndBook_NameAndUser_Username(
                        orderDTO.getBookName(),
                        orderDTO.getUserName())
                .orElseThrow(() -> new Exception("No order"));
        book.setUser(null);
        book.removeOrder(order);
        bookRepository.save(book);
        orderRepository.delete(order);
    }
}
