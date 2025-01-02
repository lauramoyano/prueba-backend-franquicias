package com.prueba.backend.infraestructure.mappers;

import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.infraestructure.entities.FranquiciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.infraestructure.utils.Constantes.SPRING_COMPONENT_MODEL;

@Mapper(
        componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IFranquiciaMapper {

    FranquiciaEntity toFranquiciaEntity(Franquicia franquicia);

    Franquicia toFranquicia(FranquiciaEntity franquiciaEntity);
}
