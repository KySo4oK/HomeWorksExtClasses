package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String getAddBookPage() {
        return "bookManagePage.html";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBookNewBookFromClient(bookDTO);
    }

    @PutMapping("/edit")
    public void editBook(@RequestBody BookDTO bookDTO) {
        bookService.editBook(bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
    }
}
