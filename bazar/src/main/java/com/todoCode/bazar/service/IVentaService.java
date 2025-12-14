/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todoCode.bazar.service;

import com.todoCode.bazar.model.Cliente;
import com.todoCode.bazar.model.Producto;
import com.todoCode.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface IVentaService {
    
    //Metodos abstractos de las ventas
    public void crearVenta(Venta p_venta);
    
    public void eliminarVenta(Long p_codigo_venta);
    
    public List<Venta> listaVentas();
    
    public Venta buscarVenta(Long p_codigo_venta);
    
    public void modificarVenta(Long p_codigo_venta, LocalDate p_fecha_venta, Double p_total, List<Producto> p_productos, Cliente p_cliente);
}
