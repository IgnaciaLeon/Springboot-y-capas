package com.example.springboot.services;

import com.example.springboot.models.Empleo;
import com.example.springboot.repositories.EmpleoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmpleoServiceImpl implements EmpleoService {

    @Autowired
    EmpleoRepository empleoRepository;

    @Override
    public Empleo guardarEmpleo(Empleo empleoNuevo) {
        return empleoRepository.save(empleoNuevo);
    }

    @Override
    public List<Empleo> listaEmpleos() {
        return empleoRepository.findAll();
    }
}