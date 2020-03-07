package extclasses.sb_with_spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
    private String password;
    private String email;
}
