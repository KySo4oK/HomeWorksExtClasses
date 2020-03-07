package extclasses.sb_with_spring_security.service;

import extclasses.sb_with_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@org.springframework.stereotype.Service
@Component
public class LoginService {
    @Autowired
    private UserRepository userRepository;
}
