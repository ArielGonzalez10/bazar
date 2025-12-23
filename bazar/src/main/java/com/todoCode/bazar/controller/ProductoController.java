/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.controller;

import com.todoCode.bazar.model.Producto;
import com.todoCode.bazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ariel
 */
@RestController
@RequestMapping("/productos")//Permite generalizar el inicio de la ruta de los endpoints
public class ProductoController {
    //Inyección de dependencia
    @Autowired
    private IProductoService productoServ;
    
    @PostMapping("/crearProducto")
    public void crearProducto(@RequestBody Producto producto){
        productoServ.crearProducto(producto);
        System.out.println("Producto creado correctamente");
    }
    
    @GetMapping("/listarProductos")
    @ResponseBody
    public List<Producto> listaProductos(){
        return productoServ.listaProductos();
    }
    
    @GetMapping("/buscar/{codigo_producto}")
    @ResponseBody()
    public Producto buscarProducto(@PathVariable Long codigo_producto){
        return productoServ.buscarProducto(codigo_producto);
    }
    
    @GetMapping("/falta_stock")
    public List<Producto> listarProductosFaltaStock(){
        return productoServ.listaStockInsuficiente();
    }
    
    @DeleteMapping("/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto){
        productoServ.eliminarProducto(codigo_producto);
        System.out.println("Producto eliminado correctamente");
    }
    
    @PutMapping("/modificar/{codigo_producto}")
    public void modificarProducto(@PathVariable Long codigo_producto,@RequestParam String nombre,@RequestParam String marca,@RequestParam Double costo, @RequestParam Double cantidad_disponible){
        productoServ.modificarProducto(codigo_producto, nombre, marca, costo, cantidad_disponible);
        System.out.println("Producto modificado correctamente");
    }
}
