package com.prueba.backend.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal {
    private Long idSucursal;
    private String nombre;
    private Long idFranquicia;



}
