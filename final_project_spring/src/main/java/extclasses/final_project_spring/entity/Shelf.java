package extclasses.final_project_spring.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shelfId;
    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", unique = true, nullable = false, updatable = false)
    private Book book;
}
