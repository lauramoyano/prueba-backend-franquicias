package com.prueba.backend.application.mappers;

import com.prueba.backend.application.dto.ProductoDto;
import com.prueba.backend.domain.models.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.application.utils.Constants.*;

@Mapper(componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductoDtoMapper {

    ProductoDto toProductoDto (Producto producto);

    Producto toProducto (ProductoDto productoDto);
}
