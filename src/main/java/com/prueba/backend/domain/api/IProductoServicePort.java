package com.prueba.backend.domain.api;

import com.prueba.backend.domain.models.Producto;

import java.util.List;

public interface IProductoServicePort {

    Producto create(Long idSucursal, Producto producto);

    Producto modificarStock(Long idProducto, Integer cantidad);

    Producto eliminarProducto(Long idProducto);

    List<Producto> listarProductosConMasStockPorFranquicia(Long idFranquicia);
}
