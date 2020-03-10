package extclasses.sb_with_spring_security.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {
    private String username;
    private String password;
}
