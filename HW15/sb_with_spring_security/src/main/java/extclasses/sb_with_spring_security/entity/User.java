package extclasses.sb_with_spring_security.entity;

import extclasses.sb_with_spring_security.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity(name = "user_ss")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private boolean active;
    private String roles;

    public User(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.active = true;
        this.roles = "ROLE_USER";
    }
}
