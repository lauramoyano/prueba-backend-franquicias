package com.prueba.backend.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private Long idProducto;
    private String nombre;
    private Integer stock;
    private Long idSucursal;





}
