package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.UserDTO;
import extclasses.final_project_spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PageController {
    final
    UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "main.html";
    }

    @GetMapping("/reg")
    public String getRegPage() {
        return "reg.html";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login.html";
    }

    @PostMapping("/reg")
    @ResponseStatus(HttpStatus.CREATED)
    public void getNewUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        userService.setNewUser(userDTO);
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