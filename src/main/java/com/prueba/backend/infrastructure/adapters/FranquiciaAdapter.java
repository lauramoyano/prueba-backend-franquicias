package com.prueba.backend.infrastructure.adapters;

import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.domain.spi.IFranquiciaPersistencePort;
import com.prueba.backend.infrastructure.entities.FranquiciaEntity;
import com.prueba.backend.infrastructure.mappers.IFranquiciaMapper;
import com.prueba.backend.infrastructure.repositories.IFranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
public class FranquiciaAdapter implements IFranquiciaPersistencePort {

    private final IFranquiciaMapper franquiciaMapper;
    private final IFranquiciaRepository franquiciaRepository;


    @Override
    public Franquicia save(Franquicia franquicia) {
        FranquiciaEntity franquiciaEntity = franquiciaRepository.save(franquiciaMapper.toFranquiciaEntity(franquicia));
        return franquiciaMapper.toFranquicia(franquiciaEntity);
    }

    @Override
    public Franquicia modificarNombre(Long idFranquicia, String nombre) {
        FranquiciaEntity franquiciaEntity = franquiciaRepository.findById(idFranquicia).orElseThrow();
        franquiciaEntity.setNombre(nombre);
        franquiciaRepository.save(franquiciaEntity);
        return franquiciaMapper.toFranquicia(franquiciaEntity);
    }

    @Override
    public Franquicia obternerFranquiciaPorNombre(String nombre) {
        FranquiciaEntity franquiciaEntity = franquiciaRepository.findByNombre(nombre);
        return franquiciaMapper.toFranquicia(franquiciaEntity);
    }

    @Override
    public Franquicia obtenerFranquiciaPorId(Long idFranquicia) {
        FranquiciaEntity franquiciaEntity = franquiciaRepository.findById(idFranquicia).orElseThrow();
        return franquiciaMapper.toFranquicia(franquiciaEntity);
    }
}
