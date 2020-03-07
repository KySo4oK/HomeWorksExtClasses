package extclasses.sb_with_spring_security.controller;

import extclasses.sb_with_spring_security.dto.UserDTO;
import extclasses.sb_with_spring_security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PageController {
    @Autowired
    private LoginService loginService;


    @PostMapping("/")
    public @ResponseBody
    String getUserFromWebPAge(UserDTO userDTO) {
        return loginService.getRoleOfUser(userDTO).toString();
    }


    @GetMapping("/")
    public String sendMainPage() {
        return "loginPage.html";
    }
}
