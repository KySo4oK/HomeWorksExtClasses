package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.exception.TagNotFoundException;
import extclasses.final_project_spring.repository.TagRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Component
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Set<String> getAllTags() {
        return LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
                tagRepository.findAll()
                        .stream()
                        .map(Tag::getName)
                        .collect(Collectors.toSet()) :
                tagRepository.findAll()
                        .stream()
                        .map(Tag::getNameUa)
                        .collect(Collectors.toSet());

    }

    public Set<Tag> getTagsByStringArray(String[] tags) {
        log.info("get tags from array {}", Arrays.toString(tags));
        return LocaleContextHolder.getLocale().equals(Locale.ENGLISH) ?
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
