package com.example.springboot.controllers;

import com.example.springboot.models.Estudiante;
import com.example.springboot.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador que siga patrón REST

@RestController
@RequestMapping("api/")//La ruta base
public class EstudianteRestController {
    @Autowired
    EstudianteServiceImpl estudianteService;

    @GetMapping("/estudiante/lista")
    public List<Estudiante> listaEstudiantes() {
        //return estudianteService.listaDeEstudiantes();
        List<Estudiante> listaMostrar = estudianteService.listaDeEstudiantes();
        return listaMostrar;
    }

    @GetMapping("/estudiante/{id}")
    public Estudiante estudiantePorId(@PathVariable Long id)//nos permite pasar ua variable a través de la ruta
    {
        Estudiante estudianteMostrar = estudianteService.buscarEstudiantePorId(id);
        return estudianteMostrar;

    }

    //crear nuevo estudiante
    @PostMapping("/estudiante/nuevo")
    public Estudiante guardarNuevoEstudiante(@RequestBody Estudiante estudianteNuevo) {//request body  nos permite enviar un objeto en formato JSON

        Estudiante estudianteParaGuardar = estudianteService.guardarEstudiante(estudianteNuevo);
        return estudianteParaGuardar;
    }
//Para borrar
    @DeleteMapping("/estudiante/borrar")//localhost:8080/api/estudiante/borrar?id=2
    public String borrarEstudiantePorId(@RequestParam Long id) { //requestparam tiene una funcionalidad parecia a
        // pathvariable pero con otra sintaxis en la url
        estudianteService.borrarEstudiante(id);
        return "El estudiante ha sido borrado";

}

//Para editar un registro
@PutMapping("estudiante/editar/{id}")
public Estudiante editarEstudiantePorId(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
    Estudiante estudianteEditado = estudianteService.editarEstudiantePorId(id, estudianteActualizado);
    return estudianteEditado;
}




}
