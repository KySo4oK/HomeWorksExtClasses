package extclasses.first_sb.repository;

import extclasses.first_sb.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
