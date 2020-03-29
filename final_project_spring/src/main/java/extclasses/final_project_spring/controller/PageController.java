package extclasses.final_project_spring.controller;

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
import java.util.stream.Collectors;


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
    public @ResponseBody
    String getNewUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        userService.setNewUser(userDTO);
        return "Congratulation";
    }

    @GetMapping("/authorities")
    public @ResponseBody
    int getAuthorities(Authentication authentication) {
        if (authentication == null) return 3;
        System.out.println(authentication.getAuthorities());
        String authorities = authentication.getAuthorities().toString();
        return authorities.contains("ADMIN") ? 1 : 2;
    }
}