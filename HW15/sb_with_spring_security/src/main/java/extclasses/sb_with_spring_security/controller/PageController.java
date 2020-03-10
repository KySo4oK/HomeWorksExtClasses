package extclasses.sb_with_spring_security.controller;

import extclasses.sb_with_spring_security.dto.UserDTO;
import extclasses.sb_with_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PageController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getMainPage() {
        return "main.html";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "redirect:/user.html";
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
    public String getNewUser(UserDTO userDTO){
        System.out.println(userDTO.toString());
        return "redirect:/";
    }

}
