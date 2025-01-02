package com.prueba.backend.infraestructure.repositories;

import com.prueba.backend.infraestructure.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<ProductoEntity, Long> {


    List<ProductoEntity> findBySucursalId (Long idSucursal);

}
