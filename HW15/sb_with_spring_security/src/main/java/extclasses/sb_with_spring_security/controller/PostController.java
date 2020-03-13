package extclasses.sb_with_spring_security.controller;

import extclasses.sb_with_spring_security.dto.UserDTO;
import extclasses.sb_with_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    private UserService userService;

    @GetMapping("/regg")
    public String getNewUser(@ModelAttribute UserDTO userDTO) {
        System.out.println("dsg");
        userService.setNewUser(userDTO);
        return "redirect:/";
    }
}
