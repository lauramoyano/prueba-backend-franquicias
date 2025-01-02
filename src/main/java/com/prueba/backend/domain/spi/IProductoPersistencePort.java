package com.prueba.backend.domain.spi;

import com.prueba.backend.domain.models.Producto;

import java.util.List;

public interface IProductoPersistencePort {

    Producto create(Producto producto);

    Producto modificarStock(Long idProducto, Integer cantidad);

    Producto eliminarProducto(Long idProducto);

    List<Producto> listarProductosConMasStockPorFranquicia(Long idFranquicia);
}
