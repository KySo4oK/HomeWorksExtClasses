package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProspectusController {
    @Autowired
    private BookService bookService;

    @GetMapping("/prospectus")
    public String getProspectusPage() {
        return "prospectus.html";
    }

    @GetMapping("/allbooks")
    public String getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();
    }
}
