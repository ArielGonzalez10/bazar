/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ariel
 */
@Getter
@Setter
public class VentaDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaDTO() {
    }

    public VentaDTO(Long codigo_venta, Double total, int cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    
}
