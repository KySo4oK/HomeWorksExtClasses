package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.UserDTO;
import extclasses.final_project_spring.entity.User;
import extclasses.final_project_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @PostConstruct
//    public void newUser() {
//        User user = new User();
//        user.setRoles("ROLE_ADMIN");
//        user.setPassword("admin");
//        user.setUsername("admin");
//        user.setActive(true);
//        user.setEmail("admin@ukr.net");
//        user.setPhone("+380966190691");
//        userRepository.save(user);
//    }


    public String getStringOfUsers() {
        List<User> users = userRepository.findAll();
        StringBuilder usersStr = new StringBuilder();
        for (User user : users) {
            usersStr.append(user.getUsername());
            usersStr.append(" , ");
        }
        return usersStr.toString();
    }

    public void setNewUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
    }
}
