package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Visit;
import fact.it.project40backendvanroey.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    Visitor findVisitorByVisitorID(int id);
    List<Visitor> findVisitorByVisit(Visit visit);
}
