package com.portfolio.demo.repository;

import com.portfolio.demo.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository <Habilidad, Long>{
    
    public Optional <Habilidad> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
