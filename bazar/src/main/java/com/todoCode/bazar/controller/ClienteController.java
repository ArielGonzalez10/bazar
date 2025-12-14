/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.controller;

import com.todoCode.bazar.model.Cliente;
import com.todoCode.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ariel
 */
@RestController
public class ClienteController {
    //Inyección de dependencia
    @Autowired
    private IClienteService clienteServ;
    
    //Endpoint para la creacion de un cliente
    @PostMapping("/clientes/crear")
    public void crearCliente(@RequestBody Cliente cliente){
        clienteServ.crearCliente(cliente);
        System.out.println("Cliente creado correctamente!");
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente){
        clienteServ.eliminarCliente(id_cliente);
        System.out.println("Cliente eliminado correctamente");
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public void modificarCliente(@PathVariable Long id_cliente,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String dni){
        clienteServ.modificarCliente(id_cliente, nombre, apellido, dni);
        System.out.println("Datos modificados correctamente");
    }
    
    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> listarClientes(){
        return clienteServ.listaClientes();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    @ResponseBody
    public Cliente buscarCliente(@PathVariable Long id_cliente){
        return clienteServ.buscarCliente(id_cliente);
    }
    
}
