package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Set<Book> findAllByUserIsNull();
}
