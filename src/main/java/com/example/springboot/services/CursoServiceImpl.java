package com.example.springboot.services;

import com.example.springboot.models.Curso;
import com.example.springboot.models.Estudiante;
import com.example.springboot.repositories.CursoRepository;
import com.example.springboot.repositories.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional// viene del concepto de transacción (cuando se produce el proceso de guardado de algo nuevo en la bvase de datos)
public class CursoServiceImpl implements CursoService {
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso crearCurso(Curso nuevoCurso){
        return cursoRepository.save(nuevoCurso);
    }


    @Override
    public List<Curso> enlistarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardarCurso(Curso cursoNuevo){
        return cursoRepository.save(cursoNuevo);
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        Boolean existe = cursoRepository.existsById(id);
        if (existe) {
            Curso cursoEscogido = cursoRepository.findById(id).get();
            return cursoEscogido;
        }else{
            System.out.println("El id es iválido o no existe");
            return null;
        }
    }

    @Override
    public void borrarCurso(Long id) {
        cursoRepository.deleteById(id);
    }


    @Override
    public Curso editarCursoPorId(Long id, Curso cursoActualizado) {
        boolean existe = cursoRepository.existsById(id);
        if (existe) {
            Curso cursoSeleccionado = cursoRepository.findById(id).get();
            cursoSeleccionado.setCursoNombre(cursoActualizado.getCursoNombre());
            cursoSeleccionado.setCursoProfesor(cursoActualizado.getCursoProfesor());
            cursoSeleccionado.setCursoTema(cursoActualizado.getCursoTema());
            cursoSeleccionado.setCursoFecha(cursoActualizado.getCursoFecha());
            System.out.println("El curso ha sido actualizado");
            return cursoRepository.save(cursoSeleccionado);
        }else{
            System.out.println("El curso no existe o el id es inválido");
            return null;
        }

    }
}