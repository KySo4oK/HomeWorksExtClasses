package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
