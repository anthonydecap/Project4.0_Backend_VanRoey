package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Visit;
import fact.it.project40backendvanroey.model.Visitor;
import fact.it.project40backendvanroey.repository.CompanyRepository;
import fact.it.project40backendvanroey.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

    @PostConstruct
    public void fillDB(){
        if(visitorRepository.count()==0){
            visitorRepository.save(new Visitor(1,"Toon","Geukens","tg@email.com"));
            visitorRepository.save(new Visitor(1,"lars","Verdonk","lv@email.com"));
            visitorRepository.save(new Visitor(2,"sam","Verdonk","sv@email.com"));
        }
    }

    @GetMapping("/visitors")
    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }

    @GetMapping("/visitors/{id}")
    public Visitor getVisitorByVisitorID(@PathVariable int id){
        return visitorRepository.findVisitorByVisitorID(id);
    }

    @PostMapping("/visitors")
    public Visitor addVisitor(@RequestBody Visitor visitor){
        visitorRepository.save(visitor);
        return visitor;
    }

    @PutMapping("/visitors")
    public Visitor updateCompany(@RequestBody Visitor visitor){
        Visitor retrievedVisitor = visitorRepository.findVisitorByVisitorID(visitor.getVisitorID());

        retrievedVisitor.setName(visitor.getName());
        retrievedVisitor.setLastname(visitor.getLastname());
        retrievedVisitor.setVisitID(visitor.getVisitID());
        retrievedVisitor.setEmail(visitor.getEmail());
        visitorRepository.save(retrievedVisitor);

        return retrievedVisitor;
    }

    @DeleteMapping("/visitors/{id}")
    public List<Visitor> deleteVisitor(@PathVariable int id){
        Visitor visitor = visitorRepository.findVisitorByVisitorID(id);

        if(visitor!=null){
            visitorRepository.delete(visitor);
        }

        return visitorRepository.findAll();
    }
}
