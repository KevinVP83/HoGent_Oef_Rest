package be.hogent.oefening.diagnosis.service.mapper;

import be.hogent.oefening.diagnosis.business.DiagnosisEntity;
import be.hogent.oefening.diagnosis.service.dto.Diagnosis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    Diagnosis toDTO(DiagnosisEntity diagnosisEntity);
    DiagnosisEntity toEntity(Diagnosis diagnosis);
}
