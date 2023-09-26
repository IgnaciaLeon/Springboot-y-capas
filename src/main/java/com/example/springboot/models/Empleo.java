package com.example.springboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "estudiantes_cyberpunk")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleoId;

    @Column (name = "nombre")
    @NotNull
    private String empleoNombre;

    @Column(name = "sueldo")
    @NotNull
    private Float empleoSueldo;

    //Constructor vacío
    public Empleo() {
    }

    //Constructor Lleno

    public Empleo(Long empleoId, String empleoNombre, Float empleoSueldo) {
        this.empleoNombre = empleoNombre;
        this.empleoSueldo = empleoSueldo;
    }

    //Getter y setter

    public Long getEmpleoId() {
        return empleoId;
    }


    public String getEmpleoNombre() {
        return empleoNombre;
    }

    public void setEmpleoNombre(String empleoNombre) {
        this.empleoNombre = empleoNombre;
    }

    public Float getEmpleoSueldo() {
        return empleoSueldo;
    }

    public void setEmpleoSueldo(Float empleoSueldo) {
        this.empleoSueldo = empleoSueldo;
    }


    //Poner alumno FK



}

//id, nombre, sueldo, alumno(fk)