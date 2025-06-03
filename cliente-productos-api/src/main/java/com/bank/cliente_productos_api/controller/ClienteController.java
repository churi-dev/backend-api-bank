package com.bank.cliente_productos_api.controller;

import com.bank.cliente_productos_api.dto.ClienteDTO;
import com.bank.cliente_productos_api.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{codigo}")
    public ClienteDTO obtenerCliente(@PathVariable("codigo") String codigoUnicoEncriptado) {
        return clienteService.obtenerClientePorCodigo(codigoUnicoEncriptado);
    }
}
