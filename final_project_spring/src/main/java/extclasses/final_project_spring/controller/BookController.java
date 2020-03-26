package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

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
    @DeleteMapping("/delete/{name}")
    public @ResponseBody
    String deleteBook(@PathVariable("name") String name) {
        bookService.deleteBook(name);
        return "successful delete book - " + name;
    }
}
