package com.sergiofcamejo.veterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas;

    public Duenio() {
    }

    public Duenio(Long id, String dni, String nombre, String apellido, String celular, List<Mascota> mascotas) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.mascotas = mascotas;
    }

}
