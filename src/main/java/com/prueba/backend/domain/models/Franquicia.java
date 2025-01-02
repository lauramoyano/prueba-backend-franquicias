package com.prueba.backend.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Franquicia {
    private Long idFranquicia;
    private String nombre;

    public Franquicia(String nombre) {
        this.nombre = nombre;
    }


}
