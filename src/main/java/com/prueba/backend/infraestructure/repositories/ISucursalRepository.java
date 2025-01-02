package com.prueba.backend.infraestructure.repositories;

import com.prueba.backend.infraestructure.entities.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISucursalRepository extends JpaRepository<SucursalEntity, Long> {


    List<SucursalEntity> findByFranquiciaId(Long idFranquicia);
}
