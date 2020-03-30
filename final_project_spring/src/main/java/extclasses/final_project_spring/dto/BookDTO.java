package extclasses.final_project_spring.dto;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.stream.Collectors;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String name;
    private String name_ua;
    private String tags;
    private String tags_ua;
    private String authors;
    private String authors_ua;

    public BookDTO(Book book) {
        this.name = book.getName();
        this.tags = book.getTags()
                .stream()
                .map(Tag::getName)
                .collect(Collectors.joining(","));
        this.authors = book.getAuthors()
                .stream()
                .map(Author::getName)
                .collect(Collectors.joining(","));
    }
}
