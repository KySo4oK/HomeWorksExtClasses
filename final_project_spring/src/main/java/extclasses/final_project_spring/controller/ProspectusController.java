package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.FilterDTO;
import extclasses.final_project_spring.service.AuthorService;
import extclasses.final_project_spring.service.BookService;
import extclasses.final_project_spring.service.OrderService;
import extclasses.final_project_spring.service.TagService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class ProspectusController {
    private final BookService bookService;
    private final TagService tagService;
    private final AuthorService authorService;
    private final OrderService orderService;

    public ProspectusController(BookService bookService, TagService tagService, AuthorService authorService, OrderService orderService) {
        this.bookService = bookService;
        this.tagService = tagService;
        this.authorService = authorService;
        this.orderService = orderService;
    }

    @GetMapping("/prospectus")
    public String getProspectusPage() {
        return "prospectus.html";
    }

    @GetMapping(value = "/books/{page}/{number}", produces = "application/json")
    public @ResponseBody
    List<BookDTO>
    getAvailableBooks(@PathVariable("page") String page, @PathVariable("number") String number) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(number));
        return bookService.getAvailableBooks(pageable);
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

    @PostMapping("/filter/{page}/{number}")
    public @ResponseBody
    List<BookDTO> getBooksByFilter(@PathVariable("page") String page,
                                   @PathVariable("number") String number,
                                   @RequestBody FilterDTO filterDTO) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(number));
        return bookService
                .getAvailableBooksByFilter(filterDTO, pageable);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public void orderBook(@RequestBody BookDTO bookDTO, Authentication authentication) {
        orderService.createOrder(bookDTO, authentication.getName());
    }
}
