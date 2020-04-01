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
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

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
                .name(LocaleContextHolder.getLocale().equals(Locale.US) ? book.getName() : book.getNameUa())
                .build();
    }

    private String[] getArrayOfTags(Book book) {
        return book.getTags()
                .stream()
                .map(LocaleContextHolder.getLocale().equals(Locale.US) ?
                        Tag::getName : Tag::getNameUa)
                .toArray(String[]::new);
    }

    private String[] getArrayOfAuthors(Book book) {
        return book.getAuthors()
                .stream()
                .map(LocaleContextHolder.getLocale().equals(Locale.US) ?
                        Author::getName : Author::getNameUa)
                .toArray(String[]::new);
    }

    @Transactional
    public void saveBookNewBookFromClient(BookDTO bookDTO) {//todo use builder
        if (bookRepository.findByName(bookDTO.getName()).isPresent())
            throw new BookAlreadyExistException("book - " + bookDTO.getName() + " already exist");
        Set<Tag> tags = tagService.createTagsByString(bookDTO.getTags());
        Set<Author> authors = authorService.getAuthorsFromStringArray(bookDTO.getAuthors());
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
                filterDTO.getTags(), pageable)
                .stream()
                .map(this::buildBookDTO)
                .collect(Collectors.toList());

    }

    public void editBook(BookDTO bookDTO) throws BookNotFoundException {
        Book book = bookRepository
                .findById(bookDTO.getId())
                .orElseThrow(() -> new BookNotFoundException("book - " + bookDTO.getName() + " not exist"));
        book.setAuthors(authorService.getAuthorsFromStringArray(bookDTO.getAuthors()));
        book.setTags(tagService.createTagsByString(bookDTO.getTags()));
        bookRepository.save(book);
    }

    public void deleteBook(long id) throws BookNotFoundException {
        bookRepository.delete(bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("book - " + id + " not exist")));
    }
}