package com.example.springboot.controllers;

import com.example.springboot.models.Curso;
import com.example.springboot.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("/api")
public class CursoRestController {
    @Autowired
    CursoRestController cursoService;

    @GetMapping ("/lista")
    public List<Curso> listaCurso () {
        List<Curso> listaMostrar = cursoService.listaCurso();
        return listaMostrar;
    }





}
