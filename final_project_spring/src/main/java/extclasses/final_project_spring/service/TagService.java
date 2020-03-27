package extclasses.final_project_spring.service;

import extclasses.final_project_spring.entity.Tag;
import extclasses.final_project_spring.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Set<String> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());
    }

    public Set<Tag> createTagsByString(String tagsString) {
        String[] tagsArray = tagsString.split(",");
        Set<Tag> tags = new HashSet<>();
        for (String s : tagsArray) {
            tags.add(tagRepository.findByName(s).orElse(new Tag(s)));
        }
        return tags;
    }
}
