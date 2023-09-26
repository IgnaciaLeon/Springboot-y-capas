package com.example.springboot.services;

import com.example.springboot.models.Estudiante;
import com.example.springboot.models.Hobby;

import java.util.List;

public interface HobbyService {
    List<Hobby> listaDeHobbies();

    Hobby buscarHobbyPorId(Long id);
    Hobby guardarHobby(Hobby hobbyNuevo);

    void borrarHobby(Long id);

   Hobby editarHobbyPorId(Long id, Hobby hobbyActualizado);

}

