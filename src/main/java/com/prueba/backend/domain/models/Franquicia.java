package com.prueba.backend.domain.models;

public class Franquicia {
    private Long id;
    private String nombre;
    private Sucursal[] sucursales;

    public Franquicia(String nombre, Sucursal[] sucursales) {
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sucursal[] getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursal[] sucursales) {
        this.sucursales = sucursales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
