package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Set<Book> getAllAvailableBooks() {
        return bookRepository.findAllByUserIsNull();
    }
}
