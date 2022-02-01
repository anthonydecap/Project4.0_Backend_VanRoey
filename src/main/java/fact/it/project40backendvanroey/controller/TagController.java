package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Tag;
import fact.it.project40backendvanroey.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tags")
    public List<Tag> all(){
        return tagRepository.findAll();
    }

    @GetMapping("/tags/{id}")
    public Tag findTagById(@PathVariable int id){
        return tagRepository.findTagByTagID(id);
    }

    @PostMapping("/tags")
    public Tag createTag(@RequestBody Tag tag){
        tagRepository.save(tag);

        return tag;
    }

    @PutMapping("/tags")
    public Tag updateTag(@RequestBody Tag tag){
        Tag update = tagRepository.findTagByTagID(tag.getTagID());

        update.setAddress(tag.getAddress());
        update.setStatus(tag.isStatus());
        tagRepository.save(update);

        return update;
    }

    @PutMapping("/tags/status")
    public Tag updateStatus(@RequestBody Tag tag){
        Tag update = tagRepository.findTagByTagID(tag.getTagID());

        update.setAddress(tag.getAddress());
        update.setStatus(!tag.isStatus());
        tagRepository.save(update);

        return update;
    }

    @DeleteMapping("/tags/{id}")
    public List<Tag> deleteTag(@PathVariable int id){
        Tag tag = tagRepository.findTagByTagID(id);

        if (tag!=null){
            tagRepository.delete(tag);
        }

        return tagRepository.findAll();
    }
}
