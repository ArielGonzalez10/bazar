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
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void crearVenta(Venta p_venta) {
        ventaRepo.save(p_venta);
    }

    @Override
    public void eliminarVenta(Long p_codigo_venta) {
        ventaRepo.deleteById(p_codigo_venta);
    }

    @Override
    public List<Venta> listaVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public Venta buscarVenta(Long p_codigo_venta) {
        Venta ventaBuscada = ventaRepo.findById(p_codigo_venta).orElse(null);
        return ventaBuscada;
    }

    @Override
    public void modificarVenta(Long p_codigo_venta, LocalDate p_fecha_venta, Double p_total, List<Producto> p_productos, Cliente p_cliente) {
        Venta ventaModif = this.buscarVenta(p_codigo_venta);
        ventaModif.setCliente(p_cliente);
        ventaModif.setFecha_venta(p_fecha_venta);
        ventaModif.setListaProductos(p_productos);
        ventaModif.setTotal(p_total);
    }
}
