package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Administrator findAdministratorById(int id);
}
