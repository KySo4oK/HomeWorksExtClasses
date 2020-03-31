package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.exception.TagNotFoundException;
import extclasses.final_project_spring.repository.TagRepository;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Set<String> getAllTags() {
        return LocaleContextHolder.getLocale().equals(Locale.US) ?
                tagRepository.findAll()
                        .stream()
                        .map(Tag::getName)
                        .collect(Collectors.toSet()) :
                tagRepository.findAll()
                        .stream()
                        .map(Tag::getNameUa)
                        .collect(Collectors.toSet());

    }

    public Set<Tag> createTagsByString(String[] tags) {
        return LocaleContextHolder.getLocale().equals(Locale.US) ?
                Arrays.stream(tags)
                        .map(x -> tagRepository
                                .findByName(x)
                                .orElseThrow(() -> new TagNotFoundException("can not found tag")))
                        .collect(Collectors.toSet()) :
                Arrays.stream(tags)
                        .map(x -> tagRepository
                                .findByNameUa(x)
                                .orElseThrow(() -> new TagNotFoundException("can not found tag")))
                        .collect(Collectors.toSet());

    }
}
