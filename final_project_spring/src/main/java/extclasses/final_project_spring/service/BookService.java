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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookService {
    private final BookRepository bookRepository;
    private final ShelfRepository shelfRepository;
    private final TagService tagService;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, ShelfRepository shelfRepository, TagService tagService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.shelfRepository = shelfRepository;
        this.tagService = tagService;
        this.authorService = authorService;
    }

    public List<BookDTO> getAvailableBooks(Pageable pageable) {
        return bookRepository.findAllByAvailableIsTrue(pageable)
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
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
        book.setNameUa(bookDTO.getNameUa());
        book.setShelf(shelf);
        book.setAuthors(authors);
        book.setTags(tags);
        bookRepository.save(book);
        shelf.setBook(book);
        shelfRepository.save(shelf);
    }

    public List<BookDTO> getAvailableBooksByFilter(FilterDTO filterDTO, Pageable pageable) {
        return bookRepository.getBooksByFilter(
                filterDTO.getName(),
                filterDTO.getAuthors(),
                filterDTO.getTags(),pageable)
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
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