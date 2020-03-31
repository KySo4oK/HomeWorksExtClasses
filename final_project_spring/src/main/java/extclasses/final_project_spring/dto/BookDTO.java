package extclasses.final_project_spring.dto;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Tag;
import lombok.*;

import java.util.Locale;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Long id;
    private String name;
    private String name_ua;
    private String tags;
    private String tags_ua;
    private String authors;
    private String authors_ua;

    public BookDTO(Book book, Locale locale) {
        this.id = book.getBookId();
        this.name = locale.equals(Locale.US) ? book.getName() : book.getNameUa();
        this.tags = locale.equals(Locale.US) ?
                book.getTags()
                        .stream()
                        .map(Tag::getName)
                        .toArray(String[]::new) :
                book.getTags()
                        .stream()
                        .map(Tag::getNameUa)
                        .toArray(String[]::new);
        this.authors = locale.equals(Locale.US) ?
                book.getAuthors()
                        .stream()
                        .map(Author::getName)
                        .toArray(String[]::new) :
                book.getAuthors()
                        .stream()
                        .map(Author::getNameUa)
                        .toArray(String[]::new);
    }
}
