package be.hogent.oefening.diagnosis.business;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class DiagnosisEntity {

    @Id
    private Long id;
    private String name;
    private String description;
}
