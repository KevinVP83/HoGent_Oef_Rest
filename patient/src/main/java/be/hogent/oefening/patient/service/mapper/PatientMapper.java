package be.hogent.oefening.patient.service.mapper;

import be.hogent.oefening.patient.business.PatientEntity;
import be.hogent.oefening.patient.service.dto.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toDTO(PatientEntity patientEntity);
    PatientEntity toEntity(Patient patient);
}
