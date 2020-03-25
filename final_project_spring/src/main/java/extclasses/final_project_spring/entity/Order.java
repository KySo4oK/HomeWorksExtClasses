package extclasses.final_project_spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "book_id")
    private Book book;
    @ToString.Exclude
    @JsonManagedReference
    private boolean active;
    @Temporal(TemporalType.DATE)
    private Date startDate = new Date();
    @Temporal(TemporalType.DATE)
    private Date endDate = new Date();
}
