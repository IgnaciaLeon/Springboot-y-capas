package com.example.springboot.services;

import com.example.springboot.models.Empleo;


import java.util.List;

public interface EmpleoService {
    List<Empleo> listaDeEmpleos();

    Empleo buscarEmpleoPorId(Long id);
    Empleo checkearEmpleo(Empleo empleoNuevo);

    Empleo borrarEmpleo(Long id);

    Empleo editarEmpleoPorId(Long id, Empleo empleoActualizado);


}

