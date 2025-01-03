package com.prueba.backend.domain.useCases;

import com.prueba.backend.domain.api.ISucursalServicePort;
import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.domain.spi.IFranquiciaPersistencePort;
import com.prueba.backend.domain.spi.ISucursalPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SucursalUseCase implements ISucursalServicePort {

    private final ISucursalPersistencePort iSucursalPersistencePort;
    private final IFranquiciaPersistencePort franquiciaPersistencePort;



    @Override
    public Sucursal create( Sucursal sucursal) {
        if (validarCamposSucursal(sucursal)) {
            throw new IllegalArgumentException("El nombre de la sucursal no puede ser nulo o vacío");
        }

        Franquicia franquicia = franquiciaPersistencePort.obtenerFranquiciaPorId(sucursal.getIdFranquicia());

        if(franquicia == null) {
            throw new IllegalArgumentException("La franquicia no existe");
        }

        Sucursal sucursalCreada = Sucursal.builder()
                .nombre(sucursal.getNombre())
                .idFranquicia(sucursal.getIdFranquicia())
                .build();

        return iSucursalPersistencePort.save(sucursalCreada);
    }

    @Override
    public Sucursal modificarNombre(Long idSucursal, String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sucursal no puede ser nulo o vacío");
        }
        Sucursal sucursalModificada = iSucursalPersistencePort.modificarNombre(idSucursal, nombre);
        return sucursalModificada;
    }

    private boolean validarCamposSucursal(Sucursal sucursal) {
        return sucursal.getNombre() == null || sucursal.getNombre().isEmpty();
    }
}
