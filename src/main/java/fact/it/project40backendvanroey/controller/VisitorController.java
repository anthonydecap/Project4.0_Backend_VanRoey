package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Visit;
import fact.it.project40backendvanroey.model.Visitor;
import fact.it.project40backendvanroey.repository.TagRepository;
import fact.it.project40backendvanroey.repository.VisitRepository;
import fact.it.project40backendvanroey.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/visitors")
    public List<Visitor> getVisitors() {
        List<Visitor> list = visitorRepository.findAll();
        list.forEach((visitor) -> visitor.setTagID(visitor.getTag().getTagID()));
        list.forEach((visitor) -> visitor.setVisitID(visitor.getVisit().getVisitID()));
        return list;
    }

    @GetMapping("/visitors/visit/active")
    public List<Visitor> getVisitorsFromActiveVisit() {
        Visit visit = visitRepository.findFirstByStatus(true);
        List<Visitor> list = visitorRepository.findVisitorByVisit(visit);
        list.forEach((visitor) -> visitor.setTagID(visitor.getTag().getTagID()));
        list.forEach((visitor) -> visitor.setVisitID(visitor.getVisit().getVisitID()));
        return list;
    }

    @GetMapping("/visitors/visit/{id}")
    public List<Visitor> getVisitorByVisitID(@PathVariable int id){
        Visit visit = visitRepository.getById(id);
        List<Visitor> list = visitorRepository.findVisitorByVisit(visit);

        list.forEach((visitor) -> visitor.setTagID(visitor.getTag().getTagID()));
        list.forEach((visitor) -> visitor.setVisitID(visitor.getVisit().getVisitID()));

        return list;
    }

    @GetMapping("/visitors/{id}")
    public Visitor getVisitorByVisitorID(@PathVariable int id){
        Visitor visitor = visitorRepository.findVisitorByVisitorID(id);
        visitor.setTagID(visitor.getTag().getTagID());
        visitor.setVisitID(visitor.getVisit().getVisitID());
        return visitorRepository.findVisitorByVisitorID(id);
    }

    @PostMapping("/visitors")
    public Visitor addVisitor(@RequestBody Visitor visitor){
        visitor.setTag(tagRepository.findTagByTagID(visitor.getTagID()));
        visitor.setVisit(visitRepository.findVisitByVisitID(visitor.getVisitID()));
        visitorRepository.save(visitor);
        return visitor;
    }

    @PutMapping("/visitors")
    public Visitor updateVisitor(@RequestBody Visitor visitor){
        Visitor retrievedVisitor = visitorRepository.findVisitorByVisitorID(visitor.getVisitorID());

        retrievedVisitor.setName(visitor.getName());
        retrievedVisitor.setLastname(visitor.getLastname());
        retrievedVisitor.setEmail(visitor.getEmail());
        retrievedVisitor.setVisitID(visitor.getVisitID());
        retrievedVisitor.setTagID(visitor.getTagID());
        retrievedVisitor.setTag(tagRepository.findTagByTagID(retrievedVisitor.getTagID()));
        retrievedVisitor.setVisit(visitRepository.findVisitByVisitID(retrievedVisitor.getVisitID()));
        visitorRepository.save(retrievedVisitor);

        return retrievedVisitor;
    }

    @DeleteMapping("/visitors/{id}")
    public List<Visitor> deleteVisitor(@PathVariable int id){
        Visitor visitor_to_delete = visitorRepository.findVisitorByVisitorID(id);

        if(visitor_to_delete!=null){
            visitorRepository.delete(visitor_to_delete);
        }

        List<Visitor> list = visitorRepository.findAll();
        list.forEach((visitor) -> visitor.setTagID(visitor.getTag().getTagID()));
        list.forEach((visitor) -> visitor.setVisitID(visitor.getVisit().getVisitID()));

        return list;
    }
}
