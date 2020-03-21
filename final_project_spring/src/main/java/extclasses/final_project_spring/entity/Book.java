package extclasses.final_project_spring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "shelf")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String name;
    private String authors;
    private String tags;
    private boolean available;
    @OneToOne(optional = false, mappedBy = "book", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Shelf shelf;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = true)
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Order> orders;
    private Date startDate;
    private Date endDate;
}
