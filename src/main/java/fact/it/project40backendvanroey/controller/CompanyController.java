package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Tracker;
import fact.it.project40backendvanroey.repository.CompanyRepository;
import fact.it.project40backendvanroey.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyByCompanyID(@PathVariable int companyID){
        return companyRepository.findCompanyByCompanyID(companyID);
    }

    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company company){
        companyRepository.save(company);
        return company;
    }

    @PutMapping("/companies")
    public Company updateCompany(@RequestBody Company company){
        Company retrievedCompany = companyRepository.findCompanyByCompanyID(company.getCompanyID());

        retrievedCompany.setName(company.getName());
        companyRepository.save(retrievedCompany);

        return retrievedCompany;
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity deleteCompany(@PathVariable int companyID){
        Company company = companyRepository.findCompanyByCompanyID(companyID);

        if(company!=null){
            companyRepository.delete(company);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
