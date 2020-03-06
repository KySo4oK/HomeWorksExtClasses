package extclasses.first_sb.controller;

import extclasses.first_sb.entity.MyLocale;
import extclasses.first_sb.repository.UserRepository;
import extclasses.first_sb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;


@Controller
public class PageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Service service;


    @PostMapping("/")
    public @ResponseBody
    String changeLocale(MyLocale myLocale) {
        service.changeLocale(myLocale.getLang());
        String nameFromDB;
        if (Service.getResourceBundle().getLocale().equals(new Locale(Service.ENG))) {
            nameFromDB = userRepository.findAll().iterator().next().getNameInLat();
        } else {
            nameFromDB = userRepository.findAll().iterator().next().getNameInUkr();
        }
        return service.getMessageFromProperties() + " " + nameFromDB;
    }

    @GetMapping("/")
    public String sendMainPage() {
        return "index.html";
    }
}
