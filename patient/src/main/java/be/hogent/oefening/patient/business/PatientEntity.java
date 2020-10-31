package be.hogent.oefening.patient.business;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PatientEntity {

    @Id
    private Long id;
    private String name;
    private String email;
}
