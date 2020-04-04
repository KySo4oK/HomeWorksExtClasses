package extclasses.final_project_spring.service;

import extclasses.final_project_spring.dto.BookDTO;
import extclasses.final_project_spring.dto.FilterDTO;
import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.entity.Book;
import extclasses.final_project_spring.entity.Shelf;
import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.exception.BookNotFoundException;
import extclasses.final_project_spring.repository.BookRepository;
import extclasses.final_project_spring.repository.ShelfRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Log4j2
@Component
public class BookService {
    private final BookRepository bookRepository;
    private final ShelfRepository shelfRepository;
    private final TagService tagService;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository,
                       ShelfRepository shelfRepository,
                       TagService tagService,
                       AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.shelfRepository = shelfRepository;
        this.tagService = tagService;
        this.authorService = authorService;
    }

    public List<BookDTO> getAvailableBooks(Pageable pageable) {
        return bookRepository.findAllByAvailableIsTrue(pageable)
                .stream()
                .map(this::buildBookDTO)
                .collect(Collectors.toList());
    }

    private BookDTO buildBookDTO(Book book) {
        return BookDTO.builder()
                .id(book.getBookId())
                .authors(getArrayOfAuthors(book))
                .tags(getArrayOfTags(book))
                .name(LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ? book.getName() : book.getNameUa())
                .build();
    }

    private String[] getArrayOfTags(Book book) {
        return book.getTags()
                .stream()
                .map(LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
                        Tag::getName : Tag::getNameUa)
                .toArray(String[]::new);
    }

    private String[] getArrayOfAuthors(Book book) {
        return book.getAuthors()
                .stream()
                .map(LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?//todo method
                        Author::getName : Author::getNameUa)
                .toArray(String[]::new);
    }

    @Transactional
    public void saveBookNewBookFromClient(BookDTO bookDTO) {
        log.info("create book {}", bookDTO);
        Shelf shelf = shelfRepository.findByBookIsNull().orElse(new Shelf());
        Book book = Book.builder()//todo
                .name(bookDTO.getName())
                .nameUa(bookDTO.getNameUa())
                .shelf(shelf)
                .authors(authorService.getAuthorsFromStringArray(bookDTO.getAuthors()))
                .tags(tagService.getTagsByStringArray(bookDTO.getTags()))
                .available(true)
                .build();
        bookRepository.save(book);//todo change logic
        shelf.setBook(book);
        shelfRepository.save(shelf);
    }

    public List<BookDTO> getAvailableBooksByFilter(FilterDTO filterDTO, Pageable pageable) {
        return bookRepository.getBooksByFilter(
                filterDTO.getName(),
                filterDTO.getAuthors(),
                filterDTO.getTags(), pageable)
                .stream()
                .map(this::buildBookDTO)
                .collect(Collectors.toList());

    }

    @Transactional
    public void editBook(BookDTO bookDTO) throws BookNotFoundException {
        log.info("save book {}", bookDTO);
        Book book = bookRepository
                .findById(bookDTO.getId())
                .orElseThrow(() -> new BookNotFoundException("book not exist"));
        book.setAuthors(authorService.getAuthorsFromStringArray(bookDTO.getAuthors()));
        book.setTags(tagService.getTagsByStringArray(bookDTO.getTags()));
        bookRepository.save(book);
    }

    public void deleteBook(long id) throws BookNotFoundException {
        log.info("delete book with id {}", id);
        bookRepository.deleteById(id);
    }
}