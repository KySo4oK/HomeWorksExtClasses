package extclasses.sb_with_spring_security.service;


import extclasses.sb_with_spring_security.entity.MyUserDetails;
import extclasses.sb_with_spring_security.entity.User;
import extclasses.sb_with_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

//    @PostConstruct
//    public void newUser() {
//        User user = new User();
//        user.setRoles("ROLE_USER");
//        user.setPassword("user");
//        user.setUsername("user");
//        user.setActive(true);
//        userRepository.save(user);
//        user = new User();
//        user.setRoles("ROLE_ADMIN");
//        user.setPassword("admin");
//        user.setUsername("admin");
//        user.setActive(true);
//        userRepository.save(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println(user.toString());

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
