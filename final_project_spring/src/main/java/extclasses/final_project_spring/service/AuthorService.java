package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.exception.AuthorNotFoundException;
import extclasses.final_project_spring.repository.AuthorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Component
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Set<String> getAllAuthors() {
        return LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
                authorRepository.findAll()
                        .stream()
                        .map(Author::getName)
                        .collect(Collectors.toSet()) :
                authorRepository.findAll()
                        .stream()
                        .map(Author::getNameUa)
                        .collect(Collectors.toSet());

    }

    public Set<Author> getAuthorsFromStringArray(String[] authors) {
        log.info("get authors from array {}", Arrays.toString(authors));
        return LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
                Arrays.stream(authors)
                        .map(x -> authorRepository
                                .findByName(x)
                                .orElseThrow(() -> new AuthorNotFoundException("can not found author")))
                        .collect(Collectors.toSet()) :
                Arrays.stream(authors)
                        .map(x -> authorRepository
                                .findByNameUa(x)
                                .orElseThrow(() -> new AuthorNotFoundException("can not found author")))
                        .collect(Collectors.toSet());
    }
}
