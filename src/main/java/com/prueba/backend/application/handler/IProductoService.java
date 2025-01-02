package com.prueba.backend.application.handler;

import com.prueba.backend.application.dto.ProductoDto;

public interface IProductoService {

    ProductoDto createProducto(ProductoDto productoDto);

    ProductoDto cambiarNombreProducto(Long id, String nombre);

    ProductoDto cambiarStockProducto(Long id, Integer stock);

    void deleteProduct(Long id);


}
