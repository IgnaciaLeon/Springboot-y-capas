package com.example.springboot.repositories;

import com.example.springboot.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    //En una interfaz solo se declaran métodos
    //Los repositorios son interfaces
    //El repositorio es la capa que se va a estar comunicando con la base de datos





}
