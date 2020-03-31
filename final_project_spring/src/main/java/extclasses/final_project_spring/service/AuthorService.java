package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Author;
import extclasses.final_project_spring.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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

    public Set<Author> createAuthorsByString(String authorsString) {
        String[] authorsArray = authorsString.split(",");
        Set<Author> authors = new HashSet<>();
        for (String s : authorsArray) {
            authors.add(authorRepository.findByName(s).orElse(new Author(s)));
        }
        return authors;
    }
}
