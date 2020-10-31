package be.hogent.oefening.patient.web.rest;

import be.hogent.oefening.patient.business.PatientEntity;
import be.hogent.oefening.patient.business.repository.PatientRepository;
import be.hogent.oefening.patient.service.PatientService;
import be.hogent.oefening.patient.service.dto.Patient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PatientResource {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAll(){
        List<Patient> patients = patientService.getAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        Patient patient = patientService.getById(id);
        if(patient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientEntity> createPatient(@RequestBody Patient patient){
        PatientEntity returnValue = new PatientEntity();
        returnValue.setId(patient.getId());
        returnValue.setEmail(patient.getEmail());
        returnValue.setName(patient.getName());

        patientRepository.save(returnValue);

        return ResponseEntity.ok(returnValue);
    }
}
