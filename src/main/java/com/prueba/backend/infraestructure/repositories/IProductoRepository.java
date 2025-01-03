package com.prueba.backend.infraestructure.repositories;

import com.prueba.backend.infraestructure.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Long> {


    List<ProductoEntity> findBySucursalId (Long idSucursal);

}
