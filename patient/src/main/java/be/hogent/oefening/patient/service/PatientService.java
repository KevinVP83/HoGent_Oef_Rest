package be.hogent.oefening.patient.service;

import be.hogent.oefening.patient.business.PatientEntity;
import be.hogent.oefening.patient.business.repository.PatientRepository;
import be.hogent.oefening.patient.service.dto.Patient;
import be.hogent.oefening.patient.service.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public List<Patient> getAll() {
        List<Patient> patientList = StreamSupport
                .stream(patientRepository.findAll().spliterator(), false)
                .map(e -> patientMapper.toDTO(e))
                .collect(Collectors.toList());

        return patientList;
    }
    public Patient getById(Long id){
        Optional<PatientEntity> patientEntityOptional = patientRepository.findById(id);
        if(patientEntityOptional.isPresent()){
            return patientMapper.toDTO(patientEntityOptional.get());
        }
        return null;
    }
}
