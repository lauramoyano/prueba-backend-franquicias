package com.prueba.backend.domain.spi;

import com.prueba.backend.domain.models.Producto;

import java.util.List;

public interface IProductoPersistencePort {

    Producto save(Producto producto);

    Producto modificarStock(Long idProducto, Integer cantidad);

    Producto eliminarProducto(Long idProducto);

    Producto modificarNombre(Long idProducto, String nombre);

    List<Producto> findBySucursalId(Long idSucursal);

    Producto findProductoConMasStockPorSucursal(Long idSucursal);

    List<Producto> findAll();

}
