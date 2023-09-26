package com.example.springboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "estudiantes_cyberpunk")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleoId;

    @Column(name = "nombre")
    @NotNull
    private String empleoNombre;

    @Column(name = "sueldo")
    @NotNull
    private Float empleoSueldo;

    //anotacion para relación 1:1
    @OneToOne
    private Estudiante estudiante;

}

//id, nombre, sueldo, alumno(fk)