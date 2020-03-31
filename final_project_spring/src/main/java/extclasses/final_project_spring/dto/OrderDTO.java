package extclasses.final_project_spring.dto;

import extclasses.final_project_spring.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String bookName;
    private String userName;
    private String startDate;
    private String endDate;

    public OrderDTO(Order order) {
        this.bookName = order.getBook().getName();
        this.userName = order.getUser().getUsername();
        this.startDate = order.getStartDate().toString();
        this.endDate = order.getEndDate().toString();
    }
}
