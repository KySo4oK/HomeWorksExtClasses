package extclasses.sb_with_spring_security.controller;

import extclasses.sb_with_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
    @Autowired
    private UserService loginService;


    @GetMapping("/")
    public String getMainPage(){
        return "main.html";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user.html";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin.html";
    }

}
