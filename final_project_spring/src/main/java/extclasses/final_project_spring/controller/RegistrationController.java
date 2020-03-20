package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

public class RegistrationController {
    @GetMapping("/reg")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "registration.html";
    }
}
