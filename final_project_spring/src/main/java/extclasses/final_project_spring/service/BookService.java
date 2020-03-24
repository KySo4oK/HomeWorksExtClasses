package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.FilterDTO;
import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Shelf;
import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private TagService tagService;
    @Autowired
    private AuthorService authorService;

//    @PostConstruct
//    public void newData() {
//        Shelf[] shelves = new Shelf[3];
//        Book[] books = new Book[shelves.length];
//        Tag[] tags = new Tag[shelves.length];
//        Author[] authors = new Author[shelves.length];
//        for (int i = 0; i < shelves.length; i++) {
//            books[i] = new Book();
//            shelves[i] = new Shelf();
//            tags[i] = new Tag();
//            authors[i] = new Author();
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
//        Author author = authors[0];
//        Tag tag = tags
//        author.setName("J. R. R. Tolkien");
//        book.getAuthors().add(author);
//        book.setAvailable(true);
//        book.setName("The Lord of the Rings");
//
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

    public Set<Book> getAvailableBooks() {
        return bookRepository.findFirst10ByAvailableIsTrue();
    }

    public boolean saveBookNewBookFromClient(BookDTO bookDTO) {
        if (bookRepository.findByName(bookDTO.getName()).isPresent()) return false;
        Set<Tag> tags = tagService.createTagsByString(bookDTO.getTags());
        Set<Author> authors = authorService.createAuthorsByString(bookDTO.getAuthors());
        Shelf shelf = shelfRepository.findByBookIsNull().orElse(new Shelf());
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setShelf(shelf);
        book.setAuthors(authors);
        book.setTags(tags);
        bookRepository.save(book);
        shelf.setBook(book);
        shelfRepository.save(shelf);
        return true;
    }

    public Set<Book> getAvailableBooksByFilter(FilterDTO filterDTO) {
        return bookRepository.getBooksByFilter(
                filterDTO.getName(),
                filterDTO.getAuthors(),
                filterDTO.getTags());
    }
}
