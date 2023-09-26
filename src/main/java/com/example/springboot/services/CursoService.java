package com.example.springboot.services;

import com.example.springboot.models.Curso;
import com.example.springboot.models.Estudiante;

import java.util.List;

public interface CursoService {
    List<Curso> enlistarCursos();

    Curso buscarCursoPorId (Long id);
    Curso guardarCurso(Curso cursoNuevo);

    void borrarCurso(Long id);

    Curso editarCursoPorId(Long id, Curso cursoActualizado);

    Curso crearCurso(Curso nuevoCurso);
}





