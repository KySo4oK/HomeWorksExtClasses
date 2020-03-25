package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByActiveFalseAndBook_NameAndUser_Username(String bookName, String userName);

    Optional<Order> findByActiveTrueAndBook_NameAndUser_Username(String bookName, String userName);

    Set<Order> findAllByActiveIsTrue();

    Set<Order> findAllByActiveIsFalse();

    Set<Order> findAllByActiveIsTrueAndUser_Username(String username);

    Set<Order> findAllByActiveIsFalseAndUser_Username(String username);
}