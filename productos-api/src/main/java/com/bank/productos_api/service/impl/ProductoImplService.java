package com.bank.productos_api.service.impl;

import com.bank.productos_api.dto.ProductoDto;
import com.bank.productos_api.mapper.ProductoMapper;
import com.bank.productos_api.repository.ProductoRepository;
import com.bank.productos_api.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImplService implements ProductoService {

    private final ProductoMapper productoMapper;

    private final ProductoRepository productoRepository;

    public ProductoImplService(ProductoMapper productoMapper,
                               ProductoRepository productoRepository) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoDto> obtenerProductoPorCodigo(String codigoEncriptado) {
        return productoMapper.toDtoList(productoRepository.findBycodigoUnico(codigoEncriptado));
    }
}
