package com.example.springboot.services;

import com.example.springboot.models.Estudiante;

import java.util.List;

//interfaz para declarar métodos
public interface EstudianteService {

  List <Estudiante> listaDeEstudiantes();

  Estudiante guardarEstudiante(Estudiante estudianteNuevo);

}
