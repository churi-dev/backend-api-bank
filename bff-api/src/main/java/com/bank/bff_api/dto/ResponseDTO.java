package com.bank.bff_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private ClienteDTO cliente;
    private List<ProductoDTO> productos;

    public ResponseDTO() {
    }

    public ResponseDTO(ClienteDTO cliente, List<ProductoDTO> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
}
