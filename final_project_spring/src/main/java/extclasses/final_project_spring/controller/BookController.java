package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.service.BookService;
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
    public @ResponseBody
    String addBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBookNewBookFromClient(bookDTO);
        return "successful adding book - " + bookDTO.getName();
    }

    @PutMapping("/edit")
    public @ResponseBody
    String editBook(@RequestBody BookDTO bookDTO) {
        bookService.editBook(bookDTO);
        return "successful edit book - " + bookDTO.getName();
    }
    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    String deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return "successful delete book - " + id;
    }
}
