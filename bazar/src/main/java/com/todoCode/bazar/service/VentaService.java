/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.service;

import com.todoCode.bazar.model.Cliente;
import com.todoCode.bazar.model.Producto;
import com.todoCode.bazar.model.Venta;
import com.todoCode.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class VentaService implements IVentaService{
    //Inyección de dependencia
    @Autowired
    private IVentaRepository ventaRepo;
    
    //Guarda una venta en la BD
    @Override
    public void crearVenta(Venta p_venta) {
        ventaRepo.save(p_venta);
    }
    
    //Elimina una venta de la BD
    @Override
    public void eliminarVenta(Long p_codigo_venta) {
        ventaRepo.deleteById(p_codigo_venta);
    }

    //Lista las ventas de la BD
    @Override
    public List<Venta> listaVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    //Busca una venta especifico en la BD
    @Override
    public Venta buscarVenta(Long p_codigo_venta) {
        Venta ventaBuscada = ventaRepo.findById(p_codigo_venta).orElse(null);
        return ventaBuscada;
    }

    //Modifica los datos de uns venta en la BD
    @Override
    public void modificarVenta(Long p_codigo_venta, LocalDate p_fecha_venta, Double p_total, List<Producto> p_productos, Cliente p_cliente) {
        Venta ventaModif = this.buscarVenta(p_codigo_venta);
        ventaModif.setCliente(p_cliente);
        ventaModif.setFecha_venta(p_fecha_venta);
        ventaModif.setListaProductos(p_productos);
        ventaModif.setTotal(p_total);
    }

    //Lista los productos de una venta
    @Override
    public List<Producto> listarProductosVenta(Long p_codigo_venta) {
        Venta ventaBusc = this.buscarVenta(p_codigo_venta);
        return ventaBusc.getListaProductos();
    }

    //Lista el monto y la cantidad de venta de un dia
    @Override
    public String ventasPorDia(LocalDate p_fecha_venta) {
       
        return "Monto del dia:"+this.calcularMontoVentas(p_fecha_venta)+", Cantidad de ventas:"+this.calcularCantidadVentas(p_fecha_venta);
    }

    //Calcula el monto recaudado de las ventas de un dia
    @Override
    public Double calcularMontoVentas(LocalDate p_fecha_venta) {
        Double montoVenta = 0.0;
        for(Venta venta: this.listaVentas()){
            if(venta.getFecha_venta() == p_fecha_venta){
                montoVenta += venta.getTotal();
            }
        }
        return montoVenta;
    }

    //Calcula la cantidad de ventas de un dia
    @Override
    public int calcularCantidadVentas(LocalDate p_fecha_venta) {
        int cantidadVentas = 0;
        for(Venta venta: this.listaVentas()){
            if(venta.getFecha_venta() == p_fecha_venta) {
                cantidadVentas++;
            }
        }
        return cantidadVentas;
    }

}
