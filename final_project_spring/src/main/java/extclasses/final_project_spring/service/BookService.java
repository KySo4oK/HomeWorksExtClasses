package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ShelfRepository shelfRepository;

//    @PostConstruct
//    public void newData() {
//        Shelf[] shelves = new Shelf[3];
//        Book[] books = new Book[shelves.length];
//        for (int i = 0; i < shelves.length; i++) {
//            books[i] = new Book();
//            shelves[i] = new Shelf();
//        }
//        for (int i = 0; i < shelves.length; i++) {
//            Book book = books[i];
////            books[i].setBookId(i);
////            shelves[i].setShelfId(i);
//            shelves[i].setBook(book);
//            book.setShelf(shelves[i]);
//        }
//        Book book = books[0];
//        Shelf shelf = shelves[0];
//        book.setAuthors("J. R. R. Tolkien");
//        book.setAvailable(true);
//        book.setName("The Lord of the Rings");
//        book.setTags("fantasy");
//        bookRepository.save(book);
//        shelfRepository.save(shelf);
//        book = books[1];
//        shelf = shelves[1];
//        book.setAuthors("Arlene Eisenberg,Heidi Murkoff");
//        book.setAvailable(true);
//        book.setName("What to Expect When You're Expecting");
//        book.setTags("fantasy,drama");
//        bookRepository.save(book);
//        shelfRepository.save(shelf);
//        book = books[2];
//        shelf = shelves[2];
//        book.setAuthors("Paulo Coelho");
//        book.setAvailable(true);
//        book.setName("The Alchemist ");
//        book.setTags("fantasy");
//        bookRepository.save(book);
//        shelfRepository.save(shelf);
//    }

    public Set<Book> getAllAvailableBooks() {
        return bookRepository.findAllByUserIsNull();
    }
}
