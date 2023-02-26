package com.portfolio.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDto {
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String institucionEd;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private int fechaInicio;
    
    @NotBlank
    private int fechaFin;

    public EducacionDto() {
    }

    public EducacionDto(String titulo, String institucionEd, String descripcion, int fechaInicio, int fechaFin) {
        this.titulo = titulo;
        this.institucionEd = institucionEd;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
    
}
