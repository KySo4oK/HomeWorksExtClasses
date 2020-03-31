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

    public BookDTO(Book book, boolean isDefaultLocale) {
        this.id = book.getBookId();
        this.name = isDefaultLocale ? book.getName() : book.getNameUa();
        this.tags = isDefaultLocale ?
                book.getTags()
                        .stream()
                        .map(Tag::getName)
                        .toArray(String[]::new) :
                book.getTags()
                        .stream()
                        .map(Tag::getNameUa)
                        .toArray(String[]::new);
        this.authors = isDefaultLocale ?
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
