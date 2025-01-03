package com.prueba.backend.domain.useCases;

import com.prueba.backend.domain.api.IProductoServicePort;
import com.prueba.backend.domain.models.Producto;
import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.domain.spi.IProductoPersistencePort;
import com.prueba.backend.domain.spi.ISucursalPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class ProductoUseCase implements IProductoServicePort {

    private final IProductoPersistencePort iProductoPersistencePort;
    private final ISucursalPersistencePort iSucursalPersistencePort;


    @Override
    public Producto create( Producto producto) {
        if (validarCamposProducto(producto)) {
            throw new IllegalArgumentException("Los campos del producto no pueden ser nulos o vacíos");
        }

        Sucursal sucursal = iSucursalPersistencePort.obtenerSucursalPorId(producto.getIdSucursal());

        if(sucursal == null) {
            throw new IllegalArgumentException("La sucursal no existe");
        }

        Producto productoCreado = Producto.builder()
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .idSucursal(producto.getIdSucursal())
                .build();

        return iProductoPersistencePort.save(productoCreado);

    }

    @Override
    public Producto modificarStock(Long idProducto, Integer cantidad) {
        if (cantidad == null || cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de stock del producto no puede ser nula o negativa");
        }
        Producto productoModificado = iProductoPersistencePort.modificarStock(idProducto, cantidad);
        return productoModificado;
    }

    @Override
    public Producto eliminarProducto(Long idProducto) {
        Producto productoEliminado = iProductoPersistencePort.eliminarProducto(idProducto);
        return productoEliminado;
    }


    @Override
    public List<Producto> listarProductosConMasStockPorFranquicia(Long idFranquicia) {
        List<Sucursal> sucursales = iSucursalPersistencePort.findByFranquiciaId(idFranquicia);
        List<Producto> productosConMasStock = new ArrayList<>();

        for (Sucursal sucursal : sucursales) {
            Producto productoConMasStock = iProductoPersistencePort.findProductoConMasStockPorSucursal(sucursal.getIdSucursal());
            if (productoConMasStock != null) {
                productosConMasStock.add(productoConMasStock);
            }
        }

        return productosConMasStock;
    }
    @Override
    public Producto modificarNombre(Long idProducto, String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío");
        }
        Producto productoModificado = iProductoPersistencePort.modificarNombre(idProducto, nombre);
        return productoModificado;
    }

    private boolean validarCamposProducto(Producto producto) {
        return producto.getNombre() == null || producto.getNombre().isEmpty() || producto.getStock() == null || producto.getStock() < 0 || producto.getIdSucursal() == null;
    }
}
