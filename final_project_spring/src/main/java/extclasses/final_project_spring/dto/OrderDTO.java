package extclasses.final_project_spring.dto;

import extclasses.final_project_spring.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

    public OrderDTO(Order order, boolean isDefaultLocale) {
        this.id = order.getOrderId();
        this.bookName = isDefaultLocale ?
                order.getBook().getName() : order.getBook().getNameUa();
        this.userName = order.getUser().getUsername();
        this.startDate = order.getStartDate()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(LocaleContextHolder.getLocale()));
        this.endDate = order.getEndDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .withLocale(LocaleContextHolder.getLocale()));
    }
}
