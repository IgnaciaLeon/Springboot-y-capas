package com.example.springboot.services;
import com.example.springboot.models.Empleo;
import java.util.List;


public interface EmpleoService {

    Empleo guardarEmpleo(Empleo empleoNuevo);


    List<Empleo> listaEmpleos();

}
