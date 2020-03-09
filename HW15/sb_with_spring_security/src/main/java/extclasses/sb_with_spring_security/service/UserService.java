package extclasses.sb_with_spring_security.service;

import extclasses.sb_with_spring_security.entity.Role;
import extclasses.sb_with_spring_security.entity.User;
import extclasses.sb_with_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void newUser() {
        User user = new User();
        user.setRole(Role.USER);
        user.setPassword("user");
        user.setUsername("user");
        userRepository.save(user);
        user = new User();
        user.setRole(Role.ADMIN);
        user.setPassword("admin");
        user.setUsername("admin");
        userRepository.save(user);
    }


}
