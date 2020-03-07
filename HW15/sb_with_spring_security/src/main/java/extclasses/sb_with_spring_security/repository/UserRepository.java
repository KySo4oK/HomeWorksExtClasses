package extclasses.sb_with_spring_security.repository;


import extclasses.sb_with_spring_security.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmailAndPassword(String email, String password);
}
