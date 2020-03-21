package extclasses.final_project_spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode(exclude = "book")
@Entity(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shelfId;
    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", unique = true, nullable = true, updatable = false)
    @ToString.Exclude
    @JsonBackReference
    private Book book;
}
