package extclasses.first_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    @PostMapping("/")
    public void changeLocale(String locale) {
        System.out.println(locale);
    }
}
