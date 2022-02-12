package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Visit;
import fact.it.project40backendvanroey.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Visit findVisitByVisitID(int id);
    List<Visit> findAllByOrderByDateAsc();
    Visit findFirstByStatus(boolean status);
}
