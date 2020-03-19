package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.UserDTO;
import extclasses.final_project_spring.service.UserService;
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
