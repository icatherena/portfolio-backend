package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String institucionEd;
    private String descripcion;
    private int fechaInicio;
    private int fechaFin;

    public Educacion() {
    }

    public Educacion(String titulo, String institucionEd, String descripcion, int fechaInicio, int fechaFin) {
        this.titulo = titulo;
        this.institucionEd = institucionEd;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
 
    
}
