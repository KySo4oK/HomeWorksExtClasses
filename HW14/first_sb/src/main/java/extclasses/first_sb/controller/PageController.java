package extclasses.first_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PageController {
    @PostMapping("/")
    public String changeLocale(MyLocale myLocale) {
        System.out.println(myLocale.getLang());
        return "index.html";
    }

    @GetMapping("/")
    public String sendMainPage() {
        return "index.html";
    }
}
