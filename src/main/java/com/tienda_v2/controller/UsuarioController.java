package com.tienda_v2.controller;

import com.tienda_v2.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/usuario/inicio") // <--- ruta del navegador
    public String inicio(Model model) {
        return "/usuario/login"; // <--- ruta del archivo en netbeans
    }
    
    @GetMapping("/usuario/registrar")
    public String register(Model model) {
        return "/usuario/register"; 
    }
}
