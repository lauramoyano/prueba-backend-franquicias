package com.prueba.backend.domain.spi;

import com.prueba.backend.domain.models.Sucursal;

import java.util.List;

public interface ISucursalPersistencePort {

    Sucursal save(Sucursal sucursal);

    Sucursal obtenerSucursalPorId(Long idSucursal);

    Sucursal modificarNombre(Long idSucursal, String nombre);

    List<Sucursal> findByFranquiciaId(Long idFranquicia);
}
