package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.FilterDTO;
import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.service.AuthorService;
import extclasses.final_project_spring.service.BookService;
import extclasses.final_project_spring.service.OrderService;
import extclasses.final_project_spring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ProspectusController {
    @Autowired
    private BookService bookService;
    @Autowired
    private TagService tagService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/prospectus")
    public String getProspectusPage() {
        return "prospectus.html";
    }

    @GetMapping(value = "/books", produces = "application/json")
    public @ResponseBody
    Set<BookDTO>
    getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @GetMapping(value = "/tags", produces = "application/json")
    public @ResponseBody
    Set<String>
    getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping(value = "/authors", produces = "application/json")
    public @ResponseBody
    Set<String>
    getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/filter")
    public @ResponseBody
    Set<BookDTO> getBooksByFilter(@RequestBody FilterDTO filterDTO) {
        return bookService
                .getAvailableBooksByFilter(filterDTO);
    }

    @PostMapping("/order")
    public @ResponseBody
    String orderBook(@RequestBody BookDTO bookDTO, Authentication authentication){
        try {
            return orderService.createOrder(bookDTO,authentication.getName()) ? "added" : "not added";
        } catch (Exception e) {
            return "not add";
        }
    }
}
