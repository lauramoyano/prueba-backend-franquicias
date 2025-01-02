package com.prueba.backend.domain.spi;

import com.prueba.backend.domain.models.Sucursal;

public interface ISucursalPersistencePort {

    Sucursal create(Sucursal sucursal);

    Sucursal obtenerSucursalPorId(Long idSucursal);
}
