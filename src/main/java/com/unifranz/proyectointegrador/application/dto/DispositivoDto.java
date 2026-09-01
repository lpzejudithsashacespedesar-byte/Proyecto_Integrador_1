package com.unifranz.proyectointegrador.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoDto {
    private String nombre;
    private String marca;
    private double precio;
}