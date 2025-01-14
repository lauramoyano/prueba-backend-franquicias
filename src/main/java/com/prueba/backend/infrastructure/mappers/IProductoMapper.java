package com.prueba.backend.infrastructure.mappers;

import com.prueba.backend.domain.models.Producto;
import com.prueba.backend.infrastructure.entities.ProductoEntity;
import com.prueba.backend.infrastructure.entities.SucursalEntity;
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
public interface IProductoMapper {

    @Mappings({
            @Mapping(source = "idSucursal", target = "sucursal")
    })
    ProductoEntity toProductoEntity(Producto producto);

    Producto toProducto(ProductoEntity productoEntity);

    default SucursalEntity mapIdToSucursalEntity(Long idSucursal) {
        if (idSucursal == null) {
            return null;
        }

        SucursalEntity sucursalEntity = new SucursalEntity();
        sucursalEntity.setId(idSucursal);
        return sucursalEntity;
    }

}
