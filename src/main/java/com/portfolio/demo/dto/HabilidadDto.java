package com.portfolio.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadDto {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private int nivel;

    public HabilidadDto() {
    }

    public HabilidadDto(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
}
