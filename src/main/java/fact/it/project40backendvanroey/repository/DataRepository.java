package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {
    Data findDataByDataID(int id);
}
