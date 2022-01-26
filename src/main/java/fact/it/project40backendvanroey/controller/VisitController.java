package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Administrator;
import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Visit;
import fact.it.project40backendvanroey.repository.CompanyRepository;
import fact.it.project40backendvanroey.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;

    @PostConstruct
    public void fillDB(){

        if(visitRepository.count()==0){
            visitRepository.save(new Visit(1,"ibm@mail.com", LocalDateTime.now(),true));
            visitRepository.save(new Visit(2,"aii@mail.com", LocalDateTime.now(),false));
        }
    }

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    @GetMapping("/visits/{id}")
    public Visit getVisitByVisitID(@PathVariable int id){
        return visitRepository.findVisitByVisitID(id);
    }

    @PostMapping("/visits")
    public Visit addVisit(@RequestBody Visit visit){
        visitRepository.save(visit);
        return visit;
    }

    @PutMapping("/visits")
    public Visit updateVisit(@RequestBody Visit visit){
        Visit retrievedVisit = visitRepository.findVisitByVisitID(visit.getVisitID());

        retrievedVisit.setCompanyID(visit.getCompanyID());
        retrievedVisit.setEmail(visit.getEmail());
        retrievedVisit.setDate(visit.getDate());
        retrievedVisit.setStatus(visit.isStatus());
        visitRepository.save(retrievedVisit);

        return retrievedVisit;
    }

    @DeleteMapping("/visits/{id}")
    public List<Visit> deleteVisit(@PathVariable int id){
        Visit visit = visitRepository.findVisitByVisitID(id);

        if(visit!=null){
            visitRepository.delete(visit);

        }

        return visitRepository.findAll();
    }
}
