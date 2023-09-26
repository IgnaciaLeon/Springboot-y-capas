package com.example.springboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity

@Table (name = "profesores_cyberpunk")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profesorId;

    @Column (name = "nombre")
    @NotNull
    private String profesorNombre;


    @Column (name = "ramo")
    @NotNull
    private String materiaImpartida;

    @Column (name = "edad")
    @NotNull
    private Integer profesorEdad;

    //Constructor Vacío

    public Profesor() {
    }

    //Constructor Lleno


    public Profesor(Long profesorId, String profesorNombre, String materiaImpartida, Integer profesorEdad) {
        this.profesorNombre = profesorNombre;
        this.materiaImpartida = materiaImpartida;
        this.profesorEdad = profesorEdad;
    }

    //Getter y Setter


    public Long getProfesorId() {
        return profesorId;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public String getMateriaImpartida() {
        return materiaImpartida;
    }

    public void setMateriaImpartida(String materiaImpartida) {
        this.materiaImpartida = materiaImpartida;
    }

    public Integer getProfesorEdad() {
        return profesorEdad;
    }

    public void setProfesorEdad(Integer profesorEdad) {
        this.profesorEdad = profesorEdad;
    }

}
