package com.bank.productos_api.service.impl;

import com.bank.productos_api.model.Producto;
import com.bank.productos_api.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    public DataLoader(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (productoRepository.count() == 0) {
            List<Producto> productos = List.of(
                    new Producto("2001", "Cuenta de Ahorro", "Ahorro Soles", 1500.50),
                    new Producto("2001", "Cuenta Corriente", "Corriente Dólares", 3200.75),
                    new Producto("2001", "Tarjeta de Crédito", "Visa Oro", 4500.00),

                    new Producto("2002", "Cuenta de Ahorro", "Cuenta Estudiante", 800.00),
                    new Producto("2002", "Cuenta Corriente", "Cuenta Negocios", 12000.25),
                    new Producto("2002", "Tarjeta de Crédito", "MasterCard Clásica", 2300.10),

                    new Producto("2003", "Cuenta de Ahorro", "Ahorro Dólares", 300.00),
                    new Producto("2003", "Cuenta Corriente", "Corriente Empresa", 9200.00),
                    new Producto("2003", "Tarjeta de Crédito", "Visa Platinum", 6700.80),

                    new Producto("2004", "Cuenta de Ahorro", "Sueldo Plus", 5000.00),
                    new Producto("2004", "Cuenta Corriente", "Corriente PyME", 15000.00),
                    new Producto("2004", "Tarjeta de Crédito", "American Express", 8000.50),

                    new Producto("2005", "Cuenta de Ahorro", "Mi Ahorro", 2500.00),
                    new Producto("2005", "Cuenta Corriente", "Cuenta Full", 4500.00),
                    new Producto("2005", "Tarjeta de Crédito", "Diners Club", 9000.00)
            );

            productoRepository.saveAll(productos);
        }
    }
}
