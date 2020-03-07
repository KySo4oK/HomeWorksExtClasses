package extclasses.sb_with_spring_security.repository;


import extclasses.sb_with_spring_security.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
}
