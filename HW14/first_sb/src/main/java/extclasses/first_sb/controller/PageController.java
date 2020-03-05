package extclasses.first_sb.controller;

import extclasses.first_sb.entity.MyLocale;
import extclasses.first_sb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PageController {
    @Autowired
    private Service service;


    @PostMapping("/")
    public @ResponseBody String changeLocale(MyLocale myLocale) {
        service.changeLocale(myLocale.getLang());
        return "done!";
    }

    @GetMapping("/")
    public String sendMainPage() {
        return "index.html";
    }
}
