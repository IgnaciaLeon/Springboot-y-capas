package com.example.springboot.controllers;

import com.example.springboot.models.Empleo;
import com.example.springboot.services.EmpleoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleoRestController {
    @Autowired
    EmpleoServiceImpl empleoService;

    @GetMapping("/lista")
    public List<Empleo> listaEmpleos() {
        List<Empleo> listaMostrar = empleoService.listaDeEmpleos();
        return listaMostrar;
    }

    @GetMapping("/empleo/{id}")
    public Empleo empleoPorId (@PathVariable Long id) {
        Empleo empleoMostrar = empleoService.buscarEmpleoPorId(id);
        return empleoMostrar;
    }

    @PostMapping ("/empleo/nuevo")
    public Empleo guardarNuevoEmpleo(@RequestBody Empleo empleoNuevo) {
        Empleo empleoParaGuardar = empleoService.checkearEmpleo(empleoNuevo);
        return empleoParaGuardar;
    }

    @DeleteMapping("/empleo/borrar")
    public String borrarEmpleoPorId(@RequestParam Long id) {
        empleoService.buscarEmpleoPorId(id);
        return "El empleo ha sido borrado";
    }

    @PutMapping ("empleo/editar/{id}")
    public Empleo editarEmpleoPorId(@PathVariable Long id, @RequestBody Empleo empleoActualizado) {
        Empleo empleoEditado = empleoService.editarEmpleoPorId(id, empleoActualizado);
        return empleoEditado;
    }

}
