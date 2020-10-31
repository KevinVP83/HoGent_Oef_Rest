package be.hogent.oefening.diagnosis.business.repository;

import be.hogent.oefening.diagnosis.business.DiagnosisEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends CrudRepository<DiagnosisEntity, Long> {
}
