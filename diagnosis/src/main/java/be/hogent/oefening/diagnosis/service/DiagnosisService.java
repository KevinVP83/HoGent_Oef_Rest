package be.hogent.oefening.diagnosis.service;

import be.hogent.oefening.diagnosis.business.DiagnosisEntity;
import be.hogent.oefening.diagnosis.business.repository.DiagnosisRepository;
import be.hogent.oefening.diagnosis.service.dto.Diagnosis;
import be.hogent.oefening.diagnosis.service.mapper.DiagnosisMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiagnosisService {
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private DiagnosisMapper diagnosisMapper;

    public DiagnosisService(DiagnosisRepository diagnosisRepository, DiagnosisMapper diagnosisMapper) {
        this.diagnosisRepository = diagnosisRepository;
        this.diagnosisMapper = diagnosisMapper;
    }

    public List<Diagnosis> getAll() {
        List<Diagnosis> diagnosisList = StreamSupport
                .stream(diagnosisRepository.findAll().spliterator(), false)
                .map(e -> diagnosisMapper.toDTO(e))
                .collect(Collectors.toList());

        return diagnosisList;
    }
    public Diagnosis getById(Long id){
        Optional<DiagnosisEntity> diagnosisEntityOptional = diagnosisRepository.findById(id);
        if(diagnosisEntityOptional.isPresent()){
            return diagnosisMapper.toDTO(diagnosisEntityOptional.get());
        }
        return null;
    }
}
