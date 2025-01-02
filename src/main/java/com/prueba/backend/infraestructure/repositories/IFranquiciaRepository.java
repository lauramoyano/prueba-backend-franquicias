package com.prueba.backend.infraestructure.repositories;

import com.prueba.backend.infraestructure.entities.FranquiciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFranquiciaRepository extends JpaRepository<FranquiciaEntity, Long> {

    FranquiciaEntity findByNombre (String nombre);




}
