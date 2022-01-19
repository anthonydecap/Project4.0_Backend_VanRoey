package fact.it.project40backendvanroey.controller;

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
    public Visit getVisitByVisitID(@PathVariable int visitID){
        return visitRepository.findVisitByVisitID(visitID);
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
    public ResponseEntity deleteVisit(@PathVariable int visitID){
        Visit visit = visitRepository.findVisitByVisitID(visitID);

        if(visit!=null){
            visitRepository.delete(visit);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
