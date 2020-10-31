package be.hogent.oefening.docter.business.repository;

import be.hogent.oefening.docter.business.DocterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocterRepository extends CrudRepository<DocterEntity, Long> {
}
