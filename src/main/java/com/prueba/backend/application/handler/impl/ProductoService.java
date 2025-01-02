package com.prueba.backend.application.handler.impl;

import com.prueba.backend.application.dto.ProductoDto;
import com.prueba.backend.application.handler.IProductoService;
import com.prueba.backend.application.mappers.IProductoDtoMapper;
import com.prueba.backend.domain.api.IProductoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

    private final IProductoServicePort productoServicePort;
    private final IProductoDtoMapper productoDtoMapper;

    @Override
    public ProductoDto createProducto(ProductoDto producto) {
        return productoDtoMapper.toProductoDto(productoServicePort.create(productoDtoMapper.toProducto(producto)));
    }

    @Override
    public ProductoDto cambiarNombreProducto(Long id, String nombre) {
        return productoDtoMapper.toProductoDto(productoServicePort.modificarNombre(id, nombre));
    }

    @Override
    public ProductoDto cambiarStockProducto(Long id, Integer stock) {
        return productoDtoMapper.toProductoDto(productoServicePort.modificarStock(id, stock));
    }

    @Override
    public void deleteProduct(Long id) {
        productoServicePort.eliminarProducto(id);
    }
}
