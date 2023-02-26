package com.portfolio.demo.repository;

import com.portfolio.demo.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    
    Optional<Educacion> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
