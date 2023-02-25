package com.portfolio.demo.repository;

import com.portfolio.demo.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long>{
 
    public Optional <Experiencia> findByCargo(String cargo);
    public boolean existsByCargo(String cargo);
    
}
