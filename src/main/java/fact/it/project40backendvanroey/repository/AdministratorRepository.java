package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Administrator findAdministratorByAdministratorID(int id);
    Administrator findAdministratorByEmail(String email);
}
