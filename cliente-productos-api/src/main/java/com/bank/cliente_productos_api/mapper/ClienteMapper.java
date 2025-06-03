package com.bank.cliente_productos_api.mapper;

import com.bank.cliente_productos_api.dto.ClienteDTO;
import com.bank.cliente_productos_api.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDto(Cliente cliente);
}
