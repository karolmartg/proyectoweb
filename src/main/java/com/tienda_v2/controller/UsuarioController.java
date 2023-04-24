package com.tienda_v2.controller;

import com.tienda_v2.dao.UsuarioDao;
import com.tienda_v2.domain.Usuario;
import com.tienda_v2.service.UsuarioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioDao usuarioDao;

    @GetMapping("/usuario/inicio-sesion") // <--- ruta del navegador
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
        return "redirect:/usuario/inicio-sesion";
    }

    @PostMapping("/usuario/login")
    public RedirectView comprobarUsuario(Usuario usuario, Model model) {
        RedirectView redirectView = new RedirectView();
        model.addAttribute("usuario", usuario);

        // validamos si el usuario existe
        if (usuarioService.findByUsername(usuario.getUsername(), usuario.getContraseña())) {
            redirectView.setUrl("/parqueo/inicio");
        } else {
            redirectView.setUrl("/usuario/inicio-sesion");
        }
        return redirectView;
    }

    // **************************************************
    @GetMapping("/usuario/mi-perfil")
    public String miPerfil(Usuario usuario, Model model) {
        usuario = usuarioService.getCurrentUser();
        model.addAttribute("usuarios", usuario);
        return "/usuario/perfil";
    }

    @PostMapping("/usuario/mi-perfil/actualizar")
    public String actualizarDatos(Usuario usuario, Model model) {
        // Si no hubo cambios en la contraseña, mantega la actual
        if (usuario.getContraseña().isEmpty()) {
            usuario.setContraseña(usuarioService.getCurrentUser().getContraseña());
        }   
        usuarioService.saveUsuario(usuario);
        model.addAttribute("usuarios", usuario);
        usuarioService.setCurrentUser(usuario.getUsername());
        return "redirect:/usuario/mi-perfil";
    }

    // **************************************************
    @GetMapping("/usuario/contacto")
    public String redirect(Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        return "/usuario/contacto";
    }

    @GetMapping("/parqueo/inicio")
    public String redirect2(Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        return "/pagina_principal";
    }

}
