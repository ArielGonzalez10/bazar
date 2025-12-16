/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.controller;


import com.todoCode.bazar.model.Cliente;
import com.todoCode.bazar.model.Producto;
import com.todoCode.bazar.model.Venta;
import com.todoCode.bazar.service.IVentaService;
import java.time.LocalDate;
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
@RequestMapping("/ventas")//Permite generalizar el inicio de la ruta de los endpoints
@RestController
public class VentaController {
    //Inyección de dependencia
    @Autowired
    private IVentaService ventaServ;
    
    @PostMapping("/crear")
    public void crearVenta(@RequestBody Venta p_venta){
        ventaServ.crearVenta(p_venta);
        System.out.println("Venta Creada correctamente");
    }
    
    @DeleteMapping("/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable Long codigo_venta){
        ventaServ.eliminarVenta(codigo_venta);
        System.out.println("Venta eliminada correctamente");
    }
    
    @PutMapping("/editar/{codigo_venta}")
    public void modificarVenta(@PathVariable Long codigo_venta,@RequestParam LocalDate fecha_venta,@RequestParam Double total,@RequestParam List<Producto> productos,@RequestParam Cliente cliente){
        ventaServ.modificarVenta(codigo_venta, fecha_venta, total, productos, cliente);
        System.out.println("Datos modificados correctamente");
    }
    
    @GetMapping("/listarVentas")
    public List<Venta> listarVentas(){
        return ventaServ.listaVentas();
    }
    
    @GetMapping("/{codigo_venta}")
    @ResponseBody
    public Venta buscarVenta(@PathVariable Long codigo_venta){
        return ventaServ.buscarVenta(codigo_venta);
    }
    
    @GetMapping("/productos/{codigo_venta}")
    @ResponseBody
    public List<Producto> listarProductosVenta(@PathVariable Long codigo_venta){
        return ventaServ.listarProductosVenta(codigo_venta);
    }
    
    @GetMapping("/{fecha_venta}")
    @ResponseBody
    public String totalVentaDia(@PathVariable LocalDate fecha_venta){
        return ventaServ.ventasPorDia(fecha_venta);
    }
}
