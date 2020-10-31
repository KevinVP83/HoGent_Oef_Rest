package be.hogent.oefening.diagnosis.web.rest;

import be.hogent.oefening.diagnosis.business.DiagnosisEntity;
import be.hogent.oefening.diagnosis.business.repository.DiagnosisRepository;
import be.hogent.oefening.diagnosis.service.DiagnosisService;
import be.hogent.oefening.diagnosis.service.dto.Diagnosis;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DiagnosisResource {

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @GetMapping("/diagnosises")
    public ResponseEntity<List<Diagnosis>> getAll(){
        List<Diagnosis> diagnoses = diagnosisService.getAll();
        return ResponseEntity.ok(diagnoses);
    }

    @GetMapping("/diagnosises/{id}")
    public ResponseEntity<Diagnosis> getById(@PathVariable Long id){
        Diagnosis diagnosis = diagnosisService.getById(id);
        if(diagnosis==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diagnosis);
    }

   @PostMapping("/diagnosises")
    public ResponseEntity<DiagnosisEntity> createDiagnosis(@RequestBody Diagnosis diagnosis){
        DiagnosisEntity returnValue = new DiagnosisEntity();
        returnValue.setId(diagnosis.getId());
        returnValue.setDescription(diagnosis.getDescription());
        returnValue.setName(diagnosis.getName());

        diagnosisRepository.save(returnValue);

        return ResponseEntity.ok(returnValue);
    }
}
