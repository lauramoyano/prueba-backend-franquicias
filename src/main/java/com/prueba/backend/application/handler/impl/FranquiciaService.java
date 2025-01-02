package com.prueba.backend.application.handler.impl;

import com.prueba.backend.application.dto.FranquiciaDto;
import com.prueba.backend.application.handler.IFranquiciaService;
import com.prueba.backend.application.mappers.IFranquiciaDtoMapper;
import com.prueba.backend.domain.api.IFranquiciaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FranquiciaService implements IFranquiciaService {

    private final IFranquiciaServicePort franquiciaServicePort;
    private final IFranquiciaDtoMapper franquiciaDtoMapper;

    @Override
    public FranquiciaDto createFranquicia(FranquiciaDto franquicia) {
        return franquiciaDtoMapper.toFranquiciaDto(franquiciaServicePort.create(franquiciaDtoMapper.toFranquicia(franquicia)));
    }

    @Override
    public FranquiciaDto cambiarNombreFranquicia(Long id, String nombre) {
        return franquiciaDtoMapper.toFranquiciaDto(franquiciaServicePort.modificarNombre(id, nombre));
    }
}
