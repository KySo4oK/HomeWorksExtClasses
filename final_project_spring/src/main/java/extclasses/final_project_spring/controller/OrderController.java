package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String getOrdersPage() {
        return "orders.html";
    }

    @PutMapping("/permit")
    public @ResponseBody
    String permitOrder(@RequestBody OrderDTO orderDTO) {
        orderService.permitOrder(orderDTO);
        return "you permit order " + orderDTO.getBookName() + " - " + orderDTO.getUserName();
    }

    @GetMapping("/active")
    public @ResponseBody
    Set<OrderDTO> getActiveOrders() {
        return orderService
                .getActiveOrders()
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/passive")
    public @ResponseBody
    Set<OrderDTO> getPassiveOrders() {
        return orderService
                .getPassiveOrders()
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user.html";
    }

    @GetMapping("/user/active")
    public @ResponseBody
    Set<OrderDTO> getActiveOrdersByUser(Authentication authentication) {
        return orderService
                .getActiveOrdersByUserName(authentication.getName())
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/user/passive")
    public @ResponseBody
    Set<OrderDTO> getPassiveOrdersByUser(Authentication authentication) {
        return orderService
                .getPassiveOrdersByUserName(authentication.getName())
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toSet());
    }

    @PutMapping("/user/return")
    public @ResponseBody
    String returnBook(@RequestBody OrderDTO orderDTO, Authentication authentication) {
        orderService.returnBook(orderDTO);
        return "you return - " + orderDTO.getBookName();
    }
}
