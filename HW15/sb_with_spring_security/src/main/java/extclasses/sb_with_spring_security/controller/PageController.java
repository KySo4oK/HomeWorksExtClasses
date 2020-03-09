package extclasses.sb_with_spring_security.controller;

import extclasses.sb_with_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PageController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getMainPage(){
        return "main.html";
    }

    @GetMapping("/user")
    public String getUserPage(){
        System.out.println("gg");
        return "redirect:/user.html";
    }

    @GetMapping("/admin")
    public @ResponseBody String getAdminPage(){
        return userService.getStringOfUsers();
    }

}
