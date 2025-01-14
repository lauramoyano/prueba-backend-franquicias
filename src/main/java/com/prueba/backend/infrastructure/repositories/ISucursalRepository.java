package com.prueba.backend.infrastructure.repositories;

import com.prueba.backend.infrastructure.entities.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ISucursalRepository extends JpaRepository<SucursalEntity, Long> {


    List<SucursalEntity> findByFranquiciaId(Long idFranquicia);
}
