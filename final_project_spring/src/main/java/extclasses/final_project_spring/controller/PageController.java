package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
        return "user.html";
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

//    @PostMapping("/regg")
//    public String getNewUser(@ModelAttribute UserDTO userDTO){
//        userService.setNewUser(userDTO);
//        return "redirect:/";
//    }

}
