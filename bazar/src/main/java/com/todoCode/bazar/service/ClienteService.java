/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.service;

import com.todoCode.bazar.model.Cliente;
import com.todoCode.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class ClienteService implements IClienteService {
    //Inyección de dependencia
    @Autowired
    private IClienteRepository clienteRepo;
    
    //Guarda un cliente en la BD
    @Override
    public void crearCliente(Cliente p_cliente) {
        clienteRepo.save(p_cliente);
    }
    
    //Elimina un cliente de la BD
    @Override
    public void eliminarCliente(Long p_id_cliente) {
        clienteRepo.deleteById(p_id_cliente);
    }

    //Lista los clientes de la BD
    @Override
    public List<Cliente> listaClientes() {
        List<Cliente> listClientes = clienteRepo.findAll();
        return listClientes;
    }

    //Busca un cliente especifico en la BD
    @Override
    public Cliente buscarCliente(Long p_id_cliente) {
        Cliente cliBuscado = clienteRepo.findById(p_id_cliente).orElse(null);
        return cliBuscado;
    }
    
    //Modifica los datos de un cliente en la BD
    @Override
    public void modificarCliente(Long p_id_cliente, String p_nombre, String p_apellido, String p_dni) {
        Cliente cliModif = this.buscarCliente(p_id_cliente);
        cliModif.setApellido(p_apellido);
        cliModif.setNombre(p_nombre);
        cliModif.setDni(p_dni);
    }
}
