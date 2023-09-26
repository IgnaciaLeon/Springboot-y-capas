package com.example.springboot.repositories;

import com.example.springboot.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    //En una interfaz solo se declaran métodos
    //Los repositorios son interfaces
    //El repositorio es la capa que se va a estar comunicando con la base de datos

    //Método para buscar estudiante por el nombre
    //Cuando estamos trabajando con el mismo modelo Jpa ofrece métodos que nos permiten especificar los atributos
    Estudiante findEstudianteByEstudianteNombre(String nombreEstudiante);

    //JPQL es una funcionalidad de JPA para transformar o crear query y nosotros podamos adaptarlas dentro d enuestro codigo
    @Query(value = "select ec.estudiante_id, ec.email, ec.estudiante_edad, ec.nombre, ec.curso_id \n" +
            "from estudiantes_cyberpunk ec\n" +
            "inner join cohortes c \n" +
            "on ec.curso_id  = c.curso_id \n" +
            "where c.nombre = ?1", nativeQuery = true) //el número sería el arguento en la posición 1
    List<Estudiante> findAllByNombreCurso(String cursoNombre);




}
