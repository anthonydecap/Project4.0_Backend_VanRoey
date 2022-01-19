package fact.it.project40backendvanroey.repository;

import fact.it.project40backendvanroey.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findTagByTagId(int id);
}
