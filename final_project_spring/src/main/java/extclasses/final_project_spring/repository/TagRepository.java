package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
