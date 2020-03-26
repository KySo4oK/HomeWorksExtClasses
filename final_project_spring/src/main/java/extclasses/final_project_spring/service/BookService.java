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

    public boolean editBook(BookDTO bookDTO) throws Exception {
        Book book = bookRepository.findByName(bookDTO.getName()).orElseThrow(() -> new Exception("book with this name not exist"));
        book.setAuthors(authorService.createAuthorsByString(bookDTO.getAuthors()));
        book.setTags(tagService.createTagsByString(bookDTO.getTags()));
        bookRepository.save(book);
        return true;
    }

    public boolean deleteBook(String name) throws Exception {
        bookRepository
                .delete(
                        bookRepository
                                .findByName(name)
                                .orElseThrow(() -> new Exception("book with this name not exist")));
        return true;
    }
}