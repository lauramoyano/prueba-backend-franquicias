package com.prueba.backend.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Sucursal {
    private Long idSucursal;
    private String nombre;
    private Long idFranquicia;

    public Sucursal(String nombre, Long idFranquicia) {
        this.nombre = nombre;
        this.idFranquicia = idFranquicia;
    }

}
