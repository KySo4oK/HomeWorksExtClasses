package extclasses.final_project_spring.controller;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.service.AuthorService;
import extclasses.final_project_spring.service.BookService;
import extclasses.final_project_spring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping(value = "/tags", produces = "application/json")
    public @ResponseBody
    List<Tag>
    getAllTags() {
        return tagService.getAllTags();
    }
    @GetMapping(value = "/authors", produces = "application/json")
    public @ResponseBody
    List<Author>
    getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
