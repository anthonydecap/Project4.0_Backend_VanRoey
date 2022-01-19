package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.VisitorTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorTagRepository extends JpaRepository<VisitorTag, Integer> {
    VisitorTag findVisitorTagByVisitorTagId(int id);
}
