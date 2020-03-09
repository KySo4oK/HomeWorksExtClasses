package extclasses.sb_with_spring_security.controller;


import extclasses.sb_with_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationPageController {
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String getRegistrationPage() {
        return "reg.html";
    }
}
