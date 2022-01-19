package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Administrator;
import fact.it.project40backendvanroey.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerAdministrator {

    @Autowired
    private AdministratorRepository administratorRepository;

    @GetMapping("/administrators")
    public List<Administrator> all(){
        return administratorRepository.findAll();
    }

    @GetMapping("/administrators/{id}")
    public Administrator getAdminById(@PathVariable int id){
        return administratorRepository.findAdministratorById(id);
    }

    @PostMapping("/administrators")
    public Administrator createAdmin(@RequestBody Administrator administrator){
        administratorRepository.save(administrator);

        return administrator;
    }

    @PutMapping("/administrators")
    public Administrator updateAdmin(@RequestBody Administrator administrator){
        Administrator update = administratorRepository.findAdministratorById(administrator.getId());

        update.setName(administrator.getName());
        update.setLastname(administrator.getLastname());
        update.setPassword(administrator.getPassword());
        update.setEmail(administrator.getEmail());

        administratorRepository.save(update);

        return update;
    }

    @DeleteMapping("/administrators/{id}")
    public List<Administrator> deleteAmdin(@RequestParam int id){
        Administrator administrator = administratorRepository.findAdministratorById(id);

        if(administrator!=null){
            administratorRepository.delete(administrator);
        }

        return administratorRepository.findAll();
    }
}
