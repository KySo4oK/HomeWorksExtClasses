package extclasses.final_project_spring.dto;

import extclasses.final_project_spring.entity.Order;
import lombok.*;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private String bookName;
    private String userName;
    private String startDate;
    private String endDate;

    public OrderDTO(Order order, Locale locale) {
        this.id = order.getOrderId();
        this.bookName = locale.equals(Locale.US) ?
                order.getBook().getName() : order.getBook().getNameUa();
        this.userName = order.getUser().getUsername();
        this.startDate = order.getStartDate()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(locale));
        this.endDate = order.getEndDate()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(locale));
    }
}
