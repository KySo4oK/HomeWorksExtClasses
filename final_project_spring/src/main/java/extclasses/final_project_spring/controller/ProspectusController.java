package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.FilterDTO;
import extclasses.final_project_spring.service.AuthorService;
import extclasses.final_project_spring.service.BookService;
import extclasses.final_project_spring.service.OrderService;
import extclasses.final_project_spring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
                .getAvailableBooksByFilter(filterDTO,pageable);
    }

    @PostMapping("/order")
    public @ResponseBody
    String orderBook(@RequestBody BookDTO bookDTO, Authentication authentication) {
        try {
            return orderService.createOrder(bookDTO, authentication.getName()) ? "added" : "not added";
        } catch (Exception e) {
            return "not add";
        }
    }
}
