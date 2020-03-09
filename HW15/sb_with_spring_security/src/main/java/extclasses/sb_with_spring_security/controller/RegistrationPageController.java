package extclasses.sb_with_spring_security.controller;

import extclasses.sb_with_spring_security.dto.UserDTO;
import extclasses.sb_with_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationPageController {
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String getRegistrationPage() {
        return "reg.html";
    }

    @PostMapping("/reg")
    public @ResponseBody
    String setNewUser(UserDTO userDTO) {
        System.out.println("hh");
        userService.regNewUser(userDTO);
        return "redirect:/";
    }

}
