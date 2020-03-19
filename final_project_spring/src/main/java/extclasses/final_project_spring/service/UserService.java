package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.UserDTO;
import extclasses.final_project_spring.entity.User;
import extclasses.final_project_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @PostConstruct
//    public void newUser() {
//        User user = new User();
//        user.setRole(Role.USER);
//        user.setPassword("user");
//        user.setUsername("user");
//        userRepository.save(user);
//        user = new User();
//        user.setRole(Role.ADMIN);
//        user.setPassword("admin");
//        user.setUsername("admin");
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
