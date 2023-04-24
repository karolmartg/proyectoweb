package com.tienda_v2.controller;

import com.tienda_v2.dao.UsuarioDao;
import com.tienda_v2.domain.Usuario;
import com.tienda_v2.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioDao usuarioDao;

    @GetMapping("/usuario/inicio") // <--- ruta del navegador
    public String inicio(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuario/login"; // <--- ruta del archivo en netbeans
    }

    @GetMapping("/usuario/registrar")
    public String register(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);
        return "/usuario/register";
    }

    @GetMapping("/usuario/registrar/{idUsuario}")
    public String modificaCliente(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/usuario/inicio";
    }

    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario, Model model) {
        usuarioService.saveUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/usuario/inicio";
    }

    @PostMapping("/usuario/login")
    public String comprobarUsuario(Usuario usuario, Model model) {
        String path=null;
        
        // validamos si el usuario existe
        if (usuarioService.findByUsername(usuario.getUsername(), usuario.getContraseña())) {
            path = "/pagina_principal"; // <---- aqui apunta si existe
        } else {
            path = "redirect:/usuario/inicio"; // <---- aqui apunta sino existe
        }
        model.addAttribute("usuario", usuario);
        return path;
    }
}
