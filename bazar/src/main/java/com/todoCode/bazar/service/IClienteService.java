/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todoCode.bazar.service;

import com.todoCode.bazar.model.Cliente;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface IClienteService {
    
    //Metodos abstractos de los clientes
    public void crearCliente(Cliente p_cliente);
    
    public void eliminarCliente(Long p_id_cliente);
    
    public List<Cliente> listaClientes();
    
    public Cliente buscarCliente(Long p_id_cliente);
    
    public void modificarCliente(Long p_id_cliente,String p_nombre, String p_apellido, String p_dni);
}
