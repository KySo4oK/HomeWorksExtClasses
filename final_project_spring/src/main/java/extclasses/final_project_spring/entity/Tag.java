package extclasses.final_project_spring.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagId;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Book> books = new HashSet<>();
}
