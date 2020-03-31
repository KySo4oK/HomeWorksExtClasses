package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.exception.AuthorNotFoundException;
import extclasses.final_project_spring.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Set<String> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(Author::getName)
                .collect(Collectors.toSet());
    }

    public Set<Author> createAuthorsByString(String[] authors) {
        return Arrays.stream(authors)
                .map(x -> authorRepository
                        .findByName(x)
                        .orElseThrow(() -> new AuthorNotFoundException("can not found tag")))
                .collect(Collectors.toSet());
    }
}
