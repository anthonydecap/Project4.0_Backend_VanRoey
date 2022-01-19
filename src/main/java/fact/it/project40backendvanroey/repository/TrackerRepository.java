package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Tag;
import fact.it.project40backendvanroey.model.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Integer> {
    Tracker findTrackerByTrackerID(int id);
}
