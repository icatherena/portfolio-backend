package com.portfolio.demo.service;

import com.portfolio.demo.model.Experiencia;
import com.portfolio.demo.repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepository experienciaRepositorio;
    
    public List <Experiencia> list(){
        return experienciaRepositorio.findAll();
    }
    
    public Optional <Experiencia> getOne(Long id){
        return experienciaRepositorio.findById(id);
    }
    
    public Optional <Experiencia> getByCargo(String cargo){
        return experienciaRepositorio.findByCargo(cargo);
    }
    
    public void save(Experiencia experiencia){
        experienciaRepositorio.save(experiencia);
    }

    public void delete(Long id){
        experienciaRepositorio.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return experienciaRepositorio.existsById(id);
    }
        
    public boolean existsByCargo(String cargo){
        return experienciaRepositorio.existsByCargo(cargo);
    }
    
}
