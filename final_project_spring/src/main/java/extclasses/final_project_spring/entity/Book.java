package extclasses.final_project_spring.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String name;
    private String authors;
    private boolean available;
    @OneToOne(optional = false, mappedBy = "book")
    private Shelf shelf;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private Date startDate;
    private Date endDate;
}
