package extclasses.sb_with_spring_security.service;

import extclasses.sb_with_spring_security.dto.UserDTO;
import extclasses.sb_with_spring_security.entity.Role;
import extclasses.sb_with_spring_security.repository.UserRepository;
import org.springframework.stereotype.Component;


@org.springframework.stereotype.Service
@Component
public class LoginService {
    private UserRepository userRepository;

    public Role getRoleOfUser(UserDTO userDTO) {
        return userRepository.findUserByEmailAndPassword(userDTO.getEmail(),userDTO.getPassword()).getRole();
    }
}
