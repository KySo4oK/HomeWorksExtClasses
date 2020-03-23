package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.service.AuthorService;
import extclasses.final_project_spring.service.BookService;
import extclasses.final_project_spring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/prospectus")
    public String getProspectusPage() {
        return "prospectus.html";
    }

    @GetMapping(value = "/books", produces = "application/json")
    public @ResponseBody
    Set<BookDTO>
    getAllAvailableBooks() {
        return bookService.getPortionOfAvailableBooks()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/tags", produces = "application/json")
    public @ResponseBody
    Set<String>
    getAllTags() {
        return tagService.getAllTags()
                .stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/authors", produces = "application/json")
    public @ResponseBody
    Set<String>
    getAllAuthors() {
        return authorService.getAllAuthors()
                .stream()
                .map(Author::getName)
                .collect(Collectors.toSet());
    }
}
