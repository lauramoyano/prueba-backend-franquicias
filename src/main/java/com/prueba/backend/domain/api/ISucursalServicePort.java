package com.prueba.backend.domain.api;

import com.prueba.backend.domain.models.Sucursal;

public interface ISucursalServicePort {

    Sucursal create( Sucursal sucursal);

    Sucursal modificarNombre(Long idSucursal, String nombre);
}
