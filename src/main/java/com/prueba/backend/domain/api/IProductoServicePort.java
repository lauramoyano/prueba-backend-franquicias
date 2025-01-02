package com.prueba.backend.domain.api;

import com.prueba.backend.domain.models.Producto;

import java.util.List;

public interface IProductoServicePort {

    Producto create( Producto producto);

    Producto modificarStock(Long idProducto, Integer cantidad);

    Producto eliminarProducto(Long idProducto);

    List<Producto> listarProductosConMasStockPorFranquicia(Long idFranquicia);

    Producto modificarNombre(Long idProducto, String nombre);
}
