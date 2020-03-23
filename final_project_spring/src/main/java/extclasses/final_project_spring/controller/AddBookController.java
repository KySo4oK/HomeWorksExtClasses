package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/add")
    public String getAddBookPage() {
        return "add.html";
    }

    @PostMapping("/add")
    public @ResponseBody
    String addBook(@RequestBody BookDTO bookDTO) {
        if (bookService.saveBookNewBookFromClient(bookDTO)) {
            return "successful";
        } else return "error";
    }
}
