package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.VisitorTag;
import fact.it.project40backendvanroey.repository.VisitorTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorTagController {

    @Autowired
    private VisitorTagRepository visitorTagRepository;

    @GetMapping("/visitor/tags")
    public List<VisitorTag> all(){
        return visitorTagRepository.findAll();
    }

    @GetMapping("/visitor/tags/{id}")
    public VisitorTag findById(@PathVariable int id){
        return visitorTagRepository.findVisitorTagByVisitorTagId(id);
    }

    @PostMapping("/visitor/tags")
    public VisitorTag createVisitorTag(@RequestBody VisitorTag visitorTag){
        visitorTagRepository.save(visitorTag);

        return visitorTag;
    }

    @PutMapping("/visitor/tags")
    public VisitorTag updateVisitorTag(@RequestBody VisitorTag visitorTag){
        VisitorTag update = visitorTagRepository.findVisitorTagByVisitorTagId(visitorTag.getVisitorTagId());

        update.setVisitorId(visitorTag.getVisitorId());
        update.setTagId(visitorTag.getTagId());
        visitorTagRepository.save(update);

        return update;
    }

    @DeleteMapping("/visitor/tags/{id}")
    public List<VisitorTag> deleteVisitorTag(@PathVariable int id){
        VisitorTag visitorTag = visitorTagRepository.findVisitorTagByVisitorTagId(id);

        if(visitorTag!=null){
            visitorTagRepository.delete(visitorTag);
        }

        return visitorTagRepository.findAll();
    }
}
