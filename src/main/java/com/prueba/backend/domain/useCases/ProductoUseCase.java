package com.prueba.backend.domain.useCases;

import com.prueba.backend.domain.api.IProductoServicePort;
import com.prueba.backend.domain.models.Producto;

import java.util.List;

public class ProductoUseCase implements IProductoServicePort {

    @Override
    public Producto create(Long idSucursal, Producto producto) {
        return null;
    }

    @Override
    public Producto modificarStock(Long idProducto, Integer cantidad) {
        return null;
    }

    @Override
    public Producto eliminarProducto(Long idProducto) {
        return null;
    }

    @Override
    public List<Producto> listarProductosConMasStockPorFranquicia(Long idFranquicia) {
        return null;
    }
}
