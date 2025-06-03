package com.bank.cliente_productos_api.service.impl;

import com.bank.cliente_productos_api.dto.ClienteDTO;
import com.bank.cliente_productos_api.mapper.ClienteMapper;
import com.bank.cliente_productos_api.repository.ClienteRepository;
import com.bank.cliente_productos_api.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO obtenerClientePorCodigo(String codigoUnicoEncriptado) {
        return clienteRepository.findBycodigoUnico(codigoUnicoEncriptado)
                .map(clienteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
