package com.portfolio.demo.repository;

import com.portfolio.demo.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {
    
    Optional <Proyecto> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);

}
