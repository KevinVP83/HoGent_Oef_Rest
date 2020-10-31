package be.hogent.oefening.patient.service.dto;

import lombok.Data;

@Data
public class Patient {

    private Long id;
    private String name;
    private String email;
}
