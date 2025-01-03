package com.prueba.backend.application.mappers;

import com.prueba.backend.application.dto.SucursalDto;
import com.prueba.backend.domain.models.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.application.utils.Constants.*;

@Mapper(componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISucursalDtoMapper {

    SucursalDto toSucursalDto (Sucursal sucursal);

    @Mapping(target = "idSucursal", ignore = true)
    Sucursal toSucursal (SucursalDto sucursalDto);
}
