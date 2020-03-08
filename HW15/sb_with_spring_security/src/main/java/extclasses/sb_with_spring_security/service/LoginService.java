package extclasses.sb_with_spring_security.service;

import extclasses.sb_with_spring_security.entity.Role;
import extclasses.sb_with_spring_security.entity.User;
import extclasses.sb_with_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public void newUser() {
        User user = new User();
        user.setId((long) 1);
        user.setPassword("123");
        user.setUsername("123");
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
    }
}
