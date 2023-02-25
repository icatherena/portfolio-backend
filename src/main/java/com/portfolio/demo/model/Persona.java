package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* ¿En qué se diferencia AUTO? */
    private Long id;
    
    private String nombre;
    private String apellido;
    private String titulo;
    private String descripcion;
    private String fotoUrl;

    /* Constructor vacío */
    public Persona() {
    }

    /* Constructor por parámetros */
    public Persona(String nombre, String apellido, String titulo, String fotoUrl) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fotoUrl = fotoUrl;
    } 
    
}
