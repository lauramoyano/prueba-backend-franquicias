package com.prueba.backend.application.handler;

import com.prueba.backend.application.dto.SucursalDto;

public interface ISucursalService {

    SucursalDto createSucursal(SucursalDto sucursalDto);

    SucursalDto cambiarNombreSucursal(Long id, String nombre);
}
