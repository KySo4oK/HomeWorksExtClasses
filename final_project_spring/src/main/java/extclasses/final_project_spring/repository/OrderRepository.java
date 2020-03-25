package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByActiveFalseAndBook_NameAndUser_Username(String bookName, String userName);
}
