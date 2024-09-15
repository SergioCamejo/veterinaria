package com.sergiofcamejo.veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DuenioDTO {

    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    private MascotaDTO mascota;

}
