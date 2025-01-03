package com.prueba.backend.application.mappers;

import com.prueba.backend.application.dto.FranquiciaDto;
import com.prueba.backend.domain.models.Franquicia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.application.utils.Constants.*;

@Mapper(componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IFranquiciaDtoMapper {

    FranquiciaDto toFranquiciaDto (Franquicia franquicia);


    Franquicia toFranquicia (FranquiciaDto franquiciaDto);
}
