package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
