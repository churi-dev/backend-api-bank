package com.bank.cliente_productos_api.service;

import com.bank.cliente_productos_api.dto.ClienteDTO;

public interface ClienteService {
    ClienteDTO obtenerClientePorCodigo(String codigoUnicoEncriptado);
}
