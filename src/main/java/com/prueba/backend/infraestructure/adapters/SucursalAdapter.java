package com.prueba.backend.infraestructure.adapters;

import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.domain.spi.ISucursalPersistencePort;
import com.prueba.backend.infraestructure.entities.SucursalEntity;
import com.prueba.backend.infraestructure.mappers.ISucursalMapper;
import com.prueba.backend.infraestructure.repositories.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
public class SucursalAdapter implements ISucursalPersistencePort {
    private final ISucursalMapper sucursalMapper;
    private final ISucursalRepository sucursalRepository;

    @Override
    public Sucursal save(Sucursal sucursal) {
        SucursalEntity sucursalEntity = sucursalRepository.save(sucursalMapper.toSucursalEntity(sucursal));
        return sucursalMapper.toSucursal(sucursalEntity);
    }

    @Override
    public Sucursal modificarNombre(Long idSucursal, String nombre) {
        SucursalEntity sucursalEntity = sucursalRepository.findById(idSucursal).orElseThrow();
        sucursalEntity.setNombre(nombre);
        sucursalRepository.save(sucursalEntity);
        return sucursalMapper.toSucursal(sucursalEntity);
    }

    @Override
    public List<Sucursal> findByFranquiciaId(Long idFranquicia) {
        List<SucursalEntity> sucursalEntities = sucursalRepository.findByFranquiciaId(idFranquicia);
        return sucursalEntities.stream()
                .map(sucursalMapper::toSucursal)
                .toList();
    }

    @Override
    public Sucursal obtenerSucursalPorId(Long idSucursal) {
        SucursalEntity sucursalEntity = sucursalRepository.findById(idSucursal).orElseThrow();
        return sucursalMapper.toSucursal(sucursalEntity);
    }

}
