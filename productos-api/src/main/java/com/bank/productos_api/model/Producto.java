package com.bank.productos_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Table(name = "productos")
@Entity
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoUnico;

    private String tipoProducto;

    private String nombre;

    private double saldo;

    public Producto() {
    }

    public Producto(String codigoUnico, String tipoProducto, String nombre, double saldo) {
        this.codigoUnico = codigoUnico;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.saldo = saldo;
    }
}
