package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/add")
    public String getAddBookPage() {
        return "add.html";
    }

    @PostMapping("/add")
    public String addBook(BookDTO bookDTO) {
        boolean result = bookService.saveBookNewBookFromClient(bookDTO);
        return "";
    }
}
