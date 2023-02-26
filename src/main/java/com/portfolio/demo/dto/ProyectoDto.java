package com.portfolio.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDto {
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String repoUrl;
    
    @NotBlank
    private String fotoUrl;

    public ProyectoDto() {
    }

    public ProyectoDto(String titulo, String descripcion, String repoUrl, String fotoUrl) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.repoUrl = repoUrl;
        this.fotoUrl = fotoUrl;
    }
    
}
