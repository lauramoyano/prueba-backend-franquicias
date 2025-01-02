package com.prueba.backend.domain.spi;

import com.prueba.backend.domain.models.Franquicia;

public interface IFranquiciaPersistencePort {

    Franquicia create(Franquicia franquicia);

    Franquicia obtenerFranquiciaPorId(Long idFranquicia);

}
