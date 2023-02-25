package com.portfolio.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    
    @NotBlank
    private String cargo;
    @NotBlank
    private String empleador;
    @NotBlank
    private String descripcion;
    @NotBlank
    private int fechaInicio;
    @NotBlank
    private int fechaFin;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String cargo, String empleador, String descripcion, int fechaInicio, int fechaFin) {
        this.cargo = cargo;
        this.empleador = empleador;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
}
