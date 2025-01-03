package com.prueba.backend.infrastructure.repositories;

import com.prueba.backend.infrastructure.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Long> {


    List<ProductoEntity>  findBySucursalId (Long idSucursal);

    @Query("SELECT p FROM ProductoEntity p WHERE p.sucursal.id = :idSucursal ORDER BY p.stock DESC")
    ProductoEntity findProductoConMasStockPorSucursal(Long idSucursal);

}
