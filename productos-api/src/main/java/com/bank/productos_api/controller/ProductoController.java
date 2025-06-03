package com.bank.productos_api.controller;

import com.bank.productos_api.dto.ProductoDto;
import com.bank.productos_api.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{codigo}")
    public List<ProductoDto> obtenerProducto(@PathVariable("codigo") String codigoEncriptado) {
        return productoService.obtenerProductoPorCodigo(codigoEncriptado);
    }
}
