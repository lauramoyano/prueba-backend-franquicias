package com.prueba.backend.domain.models;

public class Sucursal {
    private Long id;
    private String nombre;
    private Producto[] productos;

    public Sucursal(String nombre, Producto[] productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
