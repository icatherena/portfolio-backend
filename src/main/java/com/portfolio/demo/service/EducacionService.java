package com.portfolio.demo.service;

import com.portfolio.demo.model.Educacion;
import com.portfolio.demo.repository.EducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    
    @Autowired
    EducacionRepository educacionRepositorio;
    
    public List <Educacion> list() {
        return educacionRepositorio.findAll();
    }
    
    public Optional <Educacion> getOne(Long id) {
        return educacionRepositorio.findById(id); /* ¿Faltaría .orElse(null)? */
    }
    
    public Optional <Educacion> getByTitulo(String titulo) {
        return  educacionRepositorio.findByTitulo(titulo);
    }
    
    public void save(Educacion educacion) {
        educacionRepositorio.save(educacion);
    }
    
    public void delete(Long id) {
        educacionRepositorio.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return educacionRepositorio.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo) {
        return educacionRepositorio.existsByTitulo(titulo);
    }

}
