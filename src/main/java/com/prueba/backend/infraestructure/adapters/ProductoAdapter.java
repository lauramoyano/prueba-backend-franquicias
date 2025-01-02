package com.prueba.backend.infraestructure.adapters;

import com.prueba.backend.domain.models.Producto;
import com.prueba.backend.domain.spi.IProductoPersistencePort;
import com.prueba.backend.infraestructure.entities.ProductoEntity;
import com.prueba.backend.infraestructure.mappers.IProductoMapper;
import com.prueba.backend.infraestructure.repositories.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
public class ProductoAdapter implements IProductoPersistencePort {
     private final IProductoMapper productoMapper;
     private final IProductoRepository productoRepository;

     @Override
        public List<Producto> findAll() {
            List<ProductoEntity> productoEntities = productoRepository.findAll();
            return productoEntities.stream()
                    .map(productoMapper::toProducto)
                    .toList();
        }

        @Override
        public Producto save(Producto producto) {
            ProductoEntity productoEntity = productoRepository.save(productoMapper.toProductoEntity(producto));
            return productoMapper.toProducto(productoEntity);
        }

        @Override
        public Producto modificarStock(Long idProducto, Integer cantidad) {
            ProductoEntity productoEntity = productoRepository.findById(idProducto).orElseThrow();
            productoEntity.setStock(productoEntity.getStock() + cantidad);
            productoRepository.save(productoEntity);
            return productoMapper.toProducto(productoEntity);
        }

        @Override
        public Producto eliminarProducto(Long idProducto) {
            ProductoEntity productoEntity = productoRepository.findById(idProducto).orElseThrow();
            productoRepository.delete(productoEntity);
            return productoMapper.toProducto(productoEntity);
        }

        @Override
        public Producto modificarNombre(Long idProducto, String nombre) {
            ProductoEntity productoEntity = productoRepository.findById(idProducto).orElseThrow();
            productoEntity.setNombre(nombre);
            productoRepository.save(productoEntity);
            return productoMapper.toProducto(productoEntity);
        }

        @Override
        public List<Producto> findBySucursalId(Long idSucursal) {
            List<ProductoEntity> productoEntities = productoRepository.findBySucursalId(idSucursal);
            return productoEntities.stream()
                    .map(productoMapper::toProducto)
                    .toList();
        }
}
