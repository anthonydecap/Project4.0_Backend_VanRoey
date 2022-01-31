package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Tag;
import fact.it.project40backendvanroey.model.Visitor;
import fact.it.project40backendvanroey.model.VisitorTag;
import fact.it.project40backendvanroey.model.VisitorTagInfo;
import fact.it.project40backendvanroey.repository.TagRepository;
import fact.it.project40backendvanroey.repository.VisitorRepository;
import fact.it.project40backendvanroey.repository.VisitorTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class VisitorTagController {

    @Autowired
    private VisitorTagRepository visitorTagRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/visitor/tags")
    public List<VisitorTag> all(){
        return visitorTagRepository.findAll();
    }

    @GetMapping("/visitor/tags/{id}")
    public VisitorTag findById(@PathVariable int id){
        return visitorTagRepository.findVisitorTagByVisitorTagId(id);
    }

    @GetMapping("/visitor/tags/visit/{id}")
    public List<VisitorTag> list(@PathVariable int id){
        List<VisitorTag> list = new ArrayList<>();

        List<Visitor> visitors = visitorRepository.findAllByVisitID(id);

        visitors.forEach(visitor -> list.add(visitorTagRepository.findFirstByVisitorId(visitor.getVisitorID())));

        return list;
    }

    @GetMapping("/visitor/tags/info/{id}")
    public VisitorTagInfo info(@PathVariable int id){
        VisitorTag visitorTag = visitorTagRepository.findVisitorTagByVisitorTagId(id);
        Visitor visitor = visitorRepository.findVisitorByVisitorID(visitorTag.getVisitorId());
        Tag tag = tagRepository.findTagByTagId(visitorTag.getTagId());

        VisitorTagInfo visitorTagInfo = new VisitorTagInfo();

        visitorTagInfo.setVisitorName(visitor.getName());
        visitorTagInfo.setVisitorLastname(visitor.getLastname());
        visitorTagInfo.setVisitorEmail(visitor.getEmail());
        visitorTagInfo.setTagAddress(tag.getAddress());
        visitorTagInfo.setTagStatus(tag.getAddress());

        return visitorTagInfo;
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
