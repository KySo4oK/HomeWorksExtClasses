package extclasses.sb_with_spring_security.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
