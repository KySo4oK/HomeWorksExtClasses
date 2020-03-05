package extclasses.first_sb.controller;

import extclasses.first_sb.entity.MyLocale;
import extclasses.first_sb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PageController {


    private Service service;

    @Autowired
    PageController(Service service) {
        this.service = service;
    }

    @PostMapping("/")
    public String changeLocale(MyLocale myLocale) {
        service.changeLocale(myLocale.getLang());
        return "index.html";
    }

    @GetMapping("/")
    public String sendMainPage() {
        return "index.html";
    }
}
