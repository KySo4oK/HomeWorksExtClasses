package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
}
