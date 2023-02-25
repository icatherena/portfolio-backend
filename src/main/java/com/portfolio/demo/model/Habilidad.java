package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private int nivel;

    public Habilidad() {
    }

    public Habilidad(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
}
