package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;


@Entity //El uso de @Entity en Java está relacionado con el desarrollo de aplicaciones que utilizan el framework de
// persistencia JPA (Java Persistence API) para interactuar con bases de datos. @Entity es una anotación que se utiliza
// para marcar una clase de Java como una entidad persistente, lo que significa que la clase se puede mapear directamente
// a una tabla en una base de datos relacional.

@Table(name = "curso_cyberpunk")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursoId;

    @Column(name = "nombre")
    @NotNull(message = "debes poner el nombre del curso")
    private String cursoNombre;

    @Column(name = "profesor")
    @NotNull (message = "ingrese nombre del profesor")
    private String cursoProfesor;

    @Column(name = "tema")
    @NotNull (message = "ingrese tema del curso")
    private String cursoTema;

    @Column(name = "fecha")
    @DateTimeFormat
    @NotNull (message = "ingrese nombre del profesor")
    private LocalDate cursoFecha;

    @OneToMany(mappedBy = "curso")
    //@JsonBackReference
    private List<Estudiante> estudiantesCurso;


    public Curso() {
    }

    //Constructores llenos
    public Curso(Long cursoId, String cursoNombre, String cursoProfesor, String cursoTema, LocalDate cursoFecha) {
        this.cursoNombre = cursoNombre;
        this.cursoProfesor = cursoProfesor;
        this.cursoTema = cursoTema;
        this.cursoFecha = cursoFecha;
    }

    public Long getCursoId() {
        return cursoId;
    }


    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public String getCursoProfesor() {
        return cursoProfesor;
    }

    public void setCursoProfesor(String cursoProfesor) {
        this.cursoProfesor = cursoProfesor;
    }

    public String getCursoTema() {
        return cursoTema;
    }

    public void setCursoTema(String cursoTema) {
        this.cursoTema = cursoTema;
    }

    public LocalDate getCursoFecha() {
        return cursoFecha;
    }

    public void setCursoFecha(LocalDate cursoFecha) {
        this.cursoFecha = cursoFecha;
    }
}





// id, Nombre, profesor, tema, fecha