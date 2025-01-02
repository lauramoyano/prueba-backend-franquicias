package com.prueba.backend.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Producto {
    private Long idProducto;
    private String nombre;
    private Integer stock;
    private Long idSucursal;

    public Producto(String nombre, Integer stock, Long idSucursal) {
        this.nombre = nombre;
        this.stock = stock;
        this.idSucursal = idSucursal;
    }



}
