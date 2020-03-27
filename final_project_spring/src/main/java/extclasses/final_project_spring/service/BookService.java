package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.FilterDTO;
import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Shelf;
import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.exception.BookAlreadyExistException;
import extclasses.final_project_spring.exception.BookNotFoundException;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<BookDTO> getAvailableBooks() {
        return bookRepository.findFirst10ByAvailableIsTrue()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void saveBookNewBookFromClient(BookDTO bookDTO) {
        if (bookRepository.findByName(bookDTO.getName()).isPresent())
            throw new BookAlreadyExistException("book - " + bookDTO.getName() + " already exist");
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
    }

    public Set<BookDTO> getAvailableBooksByFilter(FilterDTO filterDTO) {
        return bookRepository.getBooksByFilter(
                filterDTO.getName(),
                filterDTO.getAuthors(),
                filterDTO.getTags())
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toSet());
    }

    public void editBook(BookDTO bookDTO) throws BookNotFoundException {
        Book book = bookRepository
                .findByName(bookDTO.getName())
                .orElseThrow(() -> new BookNotFoundException("book - " + bookDTO.getName() + " not exist"));
        book.setAuthors(authorService.createAuthorsByString(bookDTO.getAuthors()));
        book.setTags(tagService.createTagsByString(bookDTO.getTags()));
        bookRepository.save(book);
    }

    public void deleteBook(String name) throws BookNotFoundException {
        bookRepository.delete(bookRepository.findByName(name)
                                .orElseThrow(() -> new BookNotFoundException("book - " + name + " not exist")));
    }
}