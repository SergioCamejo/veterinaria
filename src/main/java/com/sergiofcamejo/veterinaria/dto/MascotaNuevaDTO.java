package com.sergiofcamejo.veterinaria.dto;

import com.sergiofcamejo.veterinaria.model.Especie;
import com.sergiofcamejo.veterinaria.model.Raza;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaNuevaDTO {

    private String nombre;
    private Especie especie;
    private Raza raza;
    private String color;
    private Long duenioId;

}
