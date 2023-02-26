package com.portfolio.demo.service;

import com.portfolio.demo.model.Habilidad;
import com.portfolio.demo.repository.HabilidadRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService {
 
    @Autowired
    HabilidadRepository habilidadRepositorio;
    
    public List <Habilidad> list(){
        return habilidadRepositorio.findAll();
    }
    
    public Optional <Habilidad> getOne(Long id){
        return habilidadRepositorio.findById(id);
    }
    
    public Optional <Habilidad> getByNombre(String nombre){
        return habilidadRepositorio.findByNombre(nombre);
    }
    
    public void save(Habilidad habilidad){
        habilidadRepositorio.save(habilidad);
    }
    
    public void delete(Long id){
        habilidadRepositorio.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return habilidadRepositorio.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return habilidadRepositorio.existsByNombre(nombre);
    }
    
}
