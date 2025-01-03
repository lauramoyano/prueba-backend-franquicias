package com.prueba.backend.infrastructure.mappers;

import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.infrastructure.entities.SucursalEntity;
import com.prueba.backend.infrastructure.entities.FranquiciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import static com.prueba.backend.infrastructure.utils.Constantes.SPRING_COMPONENT_MODEL;

@Mapper(
        componentModel = SPRING_COMPONENT_MODEL,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ISucursalMapper {

    @Mappings({
            @Mapping(source = "idFranquicia", target = "franquicia")
    })
    SucursalEntity toSucursalEntity(Sucursal sucursal);

    Sucursal toSucursal(SucursalEntity sucursalEntity);


    default FranquiciaEntity mapIdToFranquiciaEntity(Long idFranquicia) {
        if (idFranquicia == null) {
            return null;
        }

        FranquiciaEntity franquiciaEntity = new FranquiciaEntity();
        franquiciaEntity.setId(idFranquicia);
        return franquiciaEntity;
    }
}
