package com.bank.productos_api.service;

import com.bank.productos_api.dto.ProductoDto;

import java.util.List;


public interface ProductoService {
    List<ProductoDto> obtenerProductoPorCodigo(String codigoEncriptado);
}
