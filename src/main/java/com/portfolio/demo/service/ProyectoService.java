package com.portfolio.demo.service;

import com.portfolio.demo.model.Proyecto;
import com.portfolio.demo.repository.ProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    ProyectoRepository proyectoRepositorio;
    
    public List <Proyecto> list() {
        return proyectoRepositorio.findAll();
    }
    
    public Optional <Proyecto> getOne(Long id) {
        return proyectoRepositorio.findById(id); /* ¿Faltaría .orElse(null)? */
    }
    
    public Optional <Proyecto> getByTitulo(String titulo) {
        return  proyectoRepositorio.findByTitulo(titulo);
    }
    
    public void save(Proyecto proyecto) {
        proyectoRepositorio.save(proyecto);
    }
    
    public void delete(Long id) {
        proyectoRepositorio.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return proyectoRepositorio.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo) {
        return proyectoRepositorio.existsByTitulo(titulo);
    }
    
}
