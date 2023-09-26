package com.example.springboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.security.Timestamp;

@Entity

@Table(name = "hobby_cyberpunk")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;

    @Column(name = "nombre")
    @NotNull
    private String nombreHobby;

    @Column(name = "material")
    @NotNull
    private String materialHobby;

    @Column(name = "tiempo", columnDefinition = "TIME")
    @NotNull
    private Timestamp tiempoHobby;

    public Hobby() {
    }

    public Hobby(Long hobbyId, String nombreHobby, String materialHobby, Timestamp tiempoHobby) {
        this.nombreHobby = nombreHobby;
        this.materialHobby = materialHobby;
        this.tiempoHobby = tiempoHobby;
    }

    public Long getHobbyId() {
        return hobbyId;
    }


    public String getNombreHobby() {
        return nombreHobby;
    }

    public void setNombreHobby(String nombreHobby) {
        this.nombreHobby = nombreHobby;
    }

    public String getMaterialHobby() {
        return materialHobby;
    }

    public void setMaterialHobby(String materialHobby) {
        this.materialHobby = materialHobby;
    }

    public Timestamp getTiempoHobby() {
        return tiempoHobby;
    }

    public void setTiempoHobby(Timestamp tiempoHobby) {
        this.tiempoHobby = tiempoHobby;
    }
}
//id, nombre, material, tiempo