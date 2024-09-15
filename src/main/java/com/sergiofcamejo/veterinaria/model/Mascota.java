package com.sergiofcamejo.veterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.ORDINAL)
    private Especie especie;
    @Enumerated(EnumType.ORDINAL)
    private Raza raza;
    private String color;
    @ManyToOne
    @JoinColumn(name = "duenio_id", nullable = false)
    private Duenio duenio;

}
