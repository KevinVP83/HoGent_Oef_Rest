package be.hogent.oefening.patient.business.repository;

import be.hogent.oefening.patient.business.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long> {
}
