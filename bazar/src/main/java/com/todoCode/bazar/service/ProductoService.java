/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.service;

import com.todoCode.bazar.model.Producto;
import com.todoCode.bazar.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void crearProducto(Producto p_producto) {
        productoRepo.save(p_producto);
    }

    @Override
    public void eliminarProducto(Long p_id_producto) {
        productoRepo.deleteById(p_id_producto);
    }

    @Override
    public List<Producto> listaProductos() {
        List<Producto> listaProductos = productoRepo.findAll();
        return listaProductos;
    }

    @Override
    public Producto buscarProducto(Long p_codigo_producto) {
        Producto prodBuscado = productoRepo.findById(p_codigo_producto).orElse(null);
        return prodBuscado;
    }

    @Override
    public void modificarProducto(Long p_codigo_producto, String p_nombre, String p_marca, Double p_costo, Double p_cantidad_disponible) {
        Producto prodModif = this.buscarProducto(p_codigo_producto);
        prodModif.setCantidad_disponible(p_cantidad_disponible);
        prodModif.setCosto(p_costo);
        prodModif.setMarca(p_marca);
        prodModif.setNombre(p_nombre);
    }

    @Override
    public void actualizarStock(Long p_codigo_producto, Double p_cantidad) {
        Producto prodBuscado = this.buscarProducto(p_codigo_producto);
        
        Double stockActual = (prodBuscado.getCantidad_disponible() - p_cantidad);
        
        prodBuscado.setCantidad_disponible(stockActual);
    }
}
