package com.example.springboot.services;
import com.example.springboot.models.Empleo;
import com.example.springboot.repositories.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleoServiceImpl implements EmpleoService {

    @Autowired
    EmpleoRepository empleoRepository;

    @Override
    public Empleo checkearEmpleo (Empleo empleoNuevo) {
        if (empleoNuevo.getEmpleoSueldo() < 1) {
            System.out.println("Si no gana dinero no es un empleo");
            return null;
        }else{
            return empleoRepository.save(empleoNuevo);
        }
    }

    @Override
    public void borrarEmpleo(Long id) {empleoRepository.deleteById(id);}

    @Override
    public Empleo editarEmpleoPorId(Long id, Empleo empleoActualizado) {
        boolean existe = empleoRepository.existsById(id);
        if (existe) {
            Empleo empleoSeleccionado = empleoRepository.findById(id).get();
            empleoSeleccionado.setEmpleoNombre(empleoActualizado.getEmpleoNombre());
            empleoSeleccionado.setEmpleoSueldo(empleoActualizado.getEmpleoSueldo());
            System.out.println("El empleo ha sido actualizado");
            return empleoRepository.save(empleoSeleccionado);
        }else{
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }

    @Override
    public List<Empleo> listaDeEmpleos() { return empleoRepository.findAll();
    }

    @Override
    public Empleo buscarEmpleoPorId(Long id){
        Boolean existe = empleoRepository.existsById(id);
        if (existe) {
           Empleo empleoEscogido = empleoRepository.findById(id).get();
           return empleoEscogido;
       }else{
           System.out.println("El id es inválido o no existe");
           return null;
       }

        }
    }



