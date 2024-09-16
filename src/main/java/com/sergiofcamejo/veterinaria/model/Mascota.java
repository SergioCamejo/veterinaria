package com.sergiofcamejo.veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Duenio duenio;

    public Mascota() {
    }

    public Mascota(Long id, String nombre, Especie especie, Raza raza, String color, Duenio duenio) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.duenio = duenio;
    }

}
