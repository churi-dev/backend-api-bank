package com.bank.cliente_productos_api.service.impl;

import com.bank.cliente_productos_api.model.Cliente;
import com.bank.cliente_productos_api.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public DataLoader(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (clienteRepository.count() == 0) {
            List<Cliente> clientes = List.of(
                    new Cliente("2001", "Juan", "Pérez", "DNI", "12345678"),
                    new Cliente("2002", "Ana", "Gómez", "DNI", "87654321"),
                    new Cliente("2003", "Luis", "Ramírez", "DNI", "11223344"),
                    new Cliente("2004", "María", "Torres", "DNI", "55667788"),
                    new Cliente("2005", "Carlos", "López", "DNI", "99887766"),
                    new Cliente("2006", "Lucía", "Vargas", "DNI", "44332211"),
                    new Cliente("2007", "Pedro", "Sánchez", "DNI", "66778899"),
                    new Cliente("2008", "Carmen", "Salas", "DNI", "33445566"),
                    new Cliente("2009", "Jorge", "Fernández", "DNI", "22113344"),
                    new Cliente("2010", "Elena", "Castro", "DNI", "77889900")
            );
            clienteRepository.saveAll(clientes);
        }
    }
}
