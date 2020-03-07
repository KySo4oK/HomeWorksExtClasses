package extclasses.sb_with_spring_security.service;

import extclasses.sb_with_spring_security.dto.UserDTO;
import extclasses.sb_with_spring_security.entity.Role;
import extclasses.sb_with_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public Role getRoleOfUser(UserDTO userDTO) {
        return userRepository.findUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()).getRole();
    }
}
