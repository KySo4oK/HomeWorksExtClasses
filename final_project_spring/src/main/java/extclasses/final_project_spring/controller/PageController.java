package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.OrderDTO;
import extclasses.final_project_spring.dto.UserDTO;
import extclasses.final_project_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;


@Controller
public class PageController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getMainPage() {
        return "main.html";
    }

    @GetMapping("/admin")
    public @ResponseBody
    String getAdminPage() {
        return userService.getStringOfUsers();
    }

    @GetMapping("/reg")
    public String getRegPage() {
        return "reg.html";
    }

    @PostMapping("/reg")
    public String getNewUser(UserDTO userDTO) {
        userService.setNewUser(userDTO);
        return "redirect:/";
    }
}