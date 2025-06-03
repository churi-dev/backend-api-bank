package com.bank.productos_api.mapper;

import com.bank.productos_api.dto.ProductoDto;
import com.bank.productos_api.model.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto toDto(Producto producto);
    List<ProductoDto> toDtoList(List<Producto> productos);
}
