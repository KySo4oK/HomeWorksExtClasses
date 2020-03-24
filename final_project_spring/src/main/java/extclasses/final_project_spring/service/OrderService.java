package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Order;
import extclasses.final_project_spring.entity.User;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.OrderRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import extclasses.final_project_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        Optional<Book> bookOptional= bookRepository.findByName(bookDTO.getName());
        if(bookOptional.isEmpty()) return false;
        Book book = bookOptional.get();
        Order order = new Order();
        book.addOrder(order);
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new Exception("No user with this username"));
        order.setUser(user);
        orderRepository.save(order);
        return true;
    }
}
