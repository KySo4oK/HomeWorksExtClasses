package extclasses.final_project_spring.entity;

import extclasses.final_project_spring.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private boolean active;
    private String roles;
    private String email;
    private String phone;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Book> books;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Order> orders;

    public User(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.phone = userDTO.getPhone();
        this.email = userDTO.getEmail();
        this.active = true;
        this.roles = "ROLE_USER";
    }
}
