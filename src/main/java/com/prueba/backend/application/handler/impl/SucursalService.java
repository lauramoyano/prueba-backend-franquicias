package com.prueba.backend.application.handler.impl;

import com.prueba.backend.application.dto.SucursalDto;
import com.prueba.backend.application.handler.ISucursalService;
import com.prueba.backend.application.mappers.ISucursalDtoMapper;
import com.prueba.backend.domain.api.ISucursalServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
@Service
public class SucursalService implements ISucursalService {

    private final ISucursalServicePort sucursalServicePort;
    private final ISucursalDtoMapper sucursalDtoMapper;

    @Override
    public SucursalDto createSucursal(SucursalDto sucursalDto) {
        return sucursalDtoMapper.toSucursalDto(sucursalServicePort.create(sucursalDtoMapper.toSucursal(sucursalDto)));
    }

    @Override
    public SucursalDto cambiarNombreSucursal(Long id, String nombre) {
        return sucursalDtoMapper.toSucursalDto(sucursalServicePort.modificarNombre(id, nombre));
    }
}
