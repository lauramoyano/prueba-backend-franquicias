package com.prueba.backend.infrastructure.mappers;

import com.prueba.backend.domain.models.Producto;
import com.prueba.backend.infrastructure.entities.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.infrastructure.utils.Constantes.SPRING_COMPONENT_MODEL;

@Mapper(
        componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IProductoMapper {

    ProductoEntity toProductoEntity(Producto producto);

    Producto toProducto(ProductoEntity productoEntity);

}
