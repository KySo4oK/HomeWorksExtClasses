package extclasses.final_project_spring.dto;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private String name_ua;
    private String tags;
    private String tags_ua;
    private String authors;
    private String authors_ua;

    public BookDTO(Book book) {
        this.id = book.getBookId();
        this.name = book.getName();
        this.tags = book.getTags()
                .stream()
                .map(Tag::getName)
                .toArray(String[]::new);
        this.authors = book.getAuthors()
                .stream()
                .map(Author::getName)
                .toArray(String[]::new);
    }
}
