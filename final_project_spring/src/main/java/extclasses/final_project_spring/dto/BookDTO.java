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
    private String nameUa;
    private String[] tags;
    private String[] authors;
}
