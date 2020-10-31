package be.hogent.oefening.docter.business;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class DocterEntity {

    @Id
    private Long id;
    private Long patientId;
    private Long diagnosisId;
    private Date appointementDate;
    private Long consultation;
}
