/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoCode.bazar.controller;

import com.todoCode.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
