package be.hogent.oefening.docter.service.dto;

import lombok.Data;

@Data
public class Docter {

    private Long id;
    private Long patientId;
    private Long diagnosisId;
    private String appointementDate;
    private Long consultation;
}
