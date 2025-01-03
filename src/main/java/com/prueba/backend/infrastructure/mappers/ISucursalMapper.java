package com.prueba.backend.infrastructure.mappers;

import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.infrastructure.entities.SucursalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.infrastructure.utils.Constantes.SPRING_COMPONENT_MODEL;

@Mapper(
        componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ISucursalMapper {

    SucursalEntity toSucursalEntity(Sucursal sucursal);

    Sucursal toSucursal(SucursalEntity sucursalEntity);
}
