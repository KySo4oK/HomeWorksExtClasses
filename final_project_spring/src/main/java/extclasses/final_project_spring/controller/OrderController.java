package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
        try {
            orderService.permitOrder(orderDTO);
        } catch (Exception e) {
            return "fall";
        }
        return "success";
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
}
