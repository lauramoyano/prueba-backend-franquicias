package com.prueba.backend.domain.api;

import com.prueba.backend.domain.models.Sucursal;

public interface ISucursalServicePort {

    Sucursal create(Long idFranquicia, Sucursal sucursal);
}
