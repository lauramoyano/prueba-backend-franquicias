package com.prueba.backend.domain.useCases;

import com.prueba.backend.domain.api.IFranquiciaServicePort;
import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.domain.spi.IFranquiciaPersistencePort;

public class FranquiciaUseCase implements IFranquiciaServicePort {

    private final IFranquiciaPersistencePort franquiciaPersistencePort;

    public FranquiciaUseCase(IFranquiciaPersistencePort franquiciaPersistencePort) {
        this.franquiciaPersistencePort = franquiciaPersistencePort;
    }

    @Override
    public Franquicia create(Franquicia franquicia) {
        if (franquicia.getNombre() == null || franquicia.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la franquicia no puede ser nulo o vacío");
        }
        Franquicia franquiciaCreada = franquiciaPersistencePort.save(franquicia);
        return franquiciaCreada;
    }

    @Override
    public Franquicia modificarNombre(Long idFranquicia, String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la franquicia no puede ser nulo o vacío");
        }
        Franquicia franquiciaModificada = franquiciaPersistencePort.modificarNombre(idFranquicia, nombre);
        return franquiciaModificada;
    }
}
