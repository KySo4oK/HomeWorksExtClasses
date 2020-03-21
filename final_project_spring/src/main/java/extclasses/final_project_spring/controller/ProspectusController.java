package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class ProspectusController {
    @Autowired
    private BookService bookService;

    @GetMapping("/prospectus")
    public String getProspectusPage() {
        return "prospectus.html";
    }

    @GetMapping(value = "/books", produces = "application/json")
    public @ResponseBody
    Set<Book>
    getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();
    }
}
