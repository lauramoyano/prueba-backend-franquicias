package com.prueba.backend.infraestructure.repositories;

import com.prueba.backend.infraestructure.entities.FranquiciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFranquiciaRepository extends JpaRepository<FranquiciaEntity, Long> {

    FranquiciaEntity findByNombre (String nombre);




}
