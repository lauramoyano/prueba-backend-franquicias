package com.prueba.backend.domain.spi;

import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.domain.models.Producto;

import java.util.List;

public interface IFranquiciaPersistencePort {

    Franquicia save(Franquicia franquicia);

    Franquicia modificarNombre(Long idFranquicia, String nombre);

    Franquicia obternerFranquiciaPorNombre(String nombre);

    Franquicia obtenerFranquiciaPorId(Long idFranquicia);


}
