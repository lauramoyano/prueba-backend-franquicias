package com.prueba.backend.application.handler;

import com.prueba.backend.application.dto.FranquiciaDto;

public interface IFranquiciaService {

    FranquiciaDto createFranquicia(FranquiciaDto franquicia);

    FranquiciaDto cambiarNombreFranquicia(Long id, String nombre);

}
