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

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        List<Visit> list = visitRepository.findAll();
        list.forEach((visit) -> visit.setCompanyID(visit.getCompany().getCompanyID()));

        return list;
    }

    @GetMapping("/visits/{id}")
    public Visit getVisitByVisitID(@PathVariable int id){
        Visit visit = visitRepository.findVisitByVisitID(id);
        visit.setCompanyID(visit.getCompany().getCompanyID());
        return visit;
    }

    @GetMapping("/visits/active")
    public Visit getActiveVisit(){
        Visit visit = visitRepository.findFirstByStatus(true);
        visit.setCompanyID(visit.getCompany().getCompanyID());
        return visit;
    }

    @PostMapping("/visits")
    public Visit addVisit(@RequestBody Visit visit){
        visit.setCompany(companyRepository.findCompanyByCompanyID(visit.getCompanyID()));
        visitRepository.save(visit);

        return visit;
    }

    @PutMapping("/visits")
    public Visit updateVisit(@RequestBody Visit visit){
        Visit retrievedVisit = visitRepository.findVisitByVisitID(visit.getVisitID());
        retrievedVisit.setEmail(visit.getEmail());
        retrievedVisit.setDate(visit.getDate());
        retrievedVisit.setStatus(visit.isStatus());
        retrievedVisit.setCompanyID(visit.getCompanyID());
        retrievedVisit.setCompany(companyRepository.findCompanyByCompanyID(retrievedVisit.getCompanyID()));
        visitRepository.save(retrievedVisit);

        return retrievedVisit;
    }

    @DeleteMapping("/visits/{id}")
    public List<Visit> deleteVisit(@PathVariable int id){
        Visit visit_to_delete = visitRepository.findVisitByVisitID(id);

        if(visit_to_delete!=null){
            visitRepository.delete(visit_to_delete);
        }

        List<Visit> list = visitRepository.findAll();
        list.forEach((visit) -> visit.setCompanyID(visit.getCompany().getCompanyID()));

        return list;
    }
}
