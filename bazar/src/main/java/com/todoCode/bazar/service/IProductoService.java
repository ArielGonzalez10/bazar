/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todoCode.bazar.service;

import com.todoCode.bazar.model.Producto;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface IProductoService {
    
    //Metodos abstractos de las ventas
    public void crearProducto(Producto p_producto);
    
    public void eliminarProducto(Long p_id_producto);
    
    public List<Producto> listaProductos();
    
    public List<Producto> listaStockInsuficiente();
    
    public Producto buscarProducto(Long p_codigo_producto);
    
    public void modificarProducto(Long p_codigo_producto, String p_nombre, String p_marca, Double p_costo, Double p_cantidad_disponible);
    
    public void actualizarStock(Long p_codigo_producto, Double p_cantidad);
}
