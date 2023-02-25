package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String cargo;
    private String empleador;
    private String descripcion;
    private int fechaInicio; /* ¿Debería ser Date? */
    private int fechaFin;

    public Experiencia() {
    }

    public Experiencia(String cargo, String empleador, String descripcion, int fechaInicio, int fechaFin) {
        this.cargo = cargo;
        this.empleador = empleador;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
}
