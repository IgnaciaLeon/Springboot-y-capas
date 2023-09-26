package com.example.springboot.controllers;

import com.example.springboot.models.Estudiante;
import com.example.springboot.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Controlador que sigue patrón REST
//@RestController
@Controller

public class EstudianteController{

    //GET
    //POST
    //PUT
    //DELETE
    //PATCH

    @Autowired
    EstudianteServiceImpl estudianteService;

    //permite hacer todo tipo de peticiones, pero podemos especificar que tipo de petición queremos
    //que haga, por defecto es GET
    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public String enlistarEstudiantes(Model model) {
        List<Estudiante> listaEstudiantes = estudianteService.listaDeEstudiantes();
        model.addAttribute("estudiantes",listaEstudiantes);
        return "estudiantes";
    }

    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {//Model sirve para mapear algun objeto a la vista que estamos manejando.
        //se debe importar la librería desde Franework ui
        model.addAttribute("estudiante", new Estudiante()); //esto es para enviar el objeto o modelo al html
        return "registro";
         }

         //Controlador que se va a encargar de guardar
      @PostMapping("/nuevo")
    public String guardarEstudiante(@ModelAttribute Estudiante nuevoEstudiante) {
        // va a llamar al service y al método de guardar estudiante
          estudianteService.guardarEstudiante(nuevoEstudiante);
          return "redirect:/estudiantes";
      }

      //controlador para borrar por id
      @PostMapping("/borrar/{id}")
    public String borrarEstudiantePorId(@PathVariable Long id) {
        estudianteService.borrarEstudiante(id);
        return "redirect:/estudiantes";
      }

      //




}
