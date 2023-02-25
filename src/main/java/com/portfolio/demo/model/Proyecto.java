package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String descripcion;
    private String repoUrl;
    private String fotoUrl;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String repoUrl, String fotoUrl) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.repoUrl = repoUrl;
        this.fotoUrl = fotoUrl;
    }
    
}
