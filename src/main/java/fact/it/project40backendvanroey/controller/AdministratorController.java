package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Administrator;
import fact.it.project40backendvanroey.model.Login;
import fact.it.project40backendvanroey.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class AdministratorController {

    @Autowired
    private AdministratorRepository administratorRepository;

    @GetMapping("/administrators")
    public List<Administrator> all(){
        return administratorRepository.findAll();
    }

    @GetMapping("/administrators/{id}")
    public Administrator getAdminById(@PathVariable int id){
        return administratorRepository.findAdministratorByAdministratorID(id);
    }

    @GetMapping("/administrators/account/{email}")
    public Administrator getAdminByMail(@PathVariable String email){
        return administratorRepository.findAdministratorByEmail(email);
    }

    @GetMapping("/administrators/login")
    public boolean login(@RequestParam String email, @RequestParam String password){
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);

        Administrator administrator = administratorRepository.findAdministratorByEmail(login.getEmail());

        return administrator != null && Objects.equals(administrator.getPassword(), login.getPassword());
    }

    @PostMapping("/administrators")
    public Administrator createAdmin(@RequestBody Administrator administrator){
        administratorRepository.save(administrator);

        return administrator;
    }

    @PutMapping("/administrators")
    public Administrator updateAdmin(@RequestBody Administrator administrator){
        Administrator update = administratorRepository.findAdministratorByAdministratorID(administrator.getAdministratorID());

        update.setName(administrator.getName());
        update.setLastname(administrator.getLastname());
        update.setEmail(administrator.getEmail());

        administratorRepository.save(update);

        return update;
    }

    @DeleteMapping("/administrators/{id}")
    public List<Administrator> deleteAdmin(@PathVariable int id){
        Administrator administrator = administratorRepository.findAdministratorByAdministratorID(id);

        if(administrator!=null){
            administratorRepository.delete(administrator);
        }

        return administratorRepository.findAll();
    }
}
