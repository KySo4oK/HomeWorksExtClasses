package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PutMapping("/permit")
    public void permitOrder(@RequestBody OrderDTO orderDTO) {
        orderService.permitOrder(orderDTO);
    }

    @GetMapping("/active")
    public @ResponseBody
    Set<OrderDTO> getActiveOrders() {
        return orderService.getActiveOrders();
    }

    @GetMapping("/passive")
    public @ResponseBody
    Set<OrderDTO> getPassiveOrders() {
        return orderService.getPassiveOrders();
    }

    @GetMapping("/user/active")
    public @ResponseBody
    Set<OrderDTO> getActiveOrdersByUser(Authentication authentication) {
        return orderService.getActiveOrdersByUserName(authentication.getName());
    }

    @GetMapping("/user/passive")
    public @ResponseBody
    Set<OrderDTO> getPassiveOrdersByUser(Authentication authentication) {
        return orderService.getPassiveOrdersByUserName(authentication.getName());
    }

    @PutMapping("/user/return")
    public void returnBook(@RequestBody OrderDTO orderDTO) {
        orderService.returnBook(orderDTO);
    }
}
