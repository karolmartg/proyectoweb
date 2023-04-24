package com.tienda_v2.controller;

import com.tienda_v2.dao.UbicacionesDao;
import com.tienda_v2.domain.Reserva;
import com.tienda_v2.domain.Ubicaciones;
import com.tienda_v2.service.UbicacionesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UbicacionesController {

    @Autowired
    UbicacionesService ubicacionesService;
    @Autowired
    UbicacionesDao ubicacionesDao;

    @GetMapping("/ubicaciones")
    public String inicio(Model model, Ubicaciones ubicacion) {
        var ubicaciones = ubicacionesService.getUbicaciones();
        model.addAttribute("ubicaciones", ubicaciones);
        return "/ubicacion/ubicaciones";
    }

    @PostMapping("/ubicaciones/reservar")
    public String reservar(Model model, Ubicaciones ubicacion) {
        model.addAttribute("ubicaciones", ubicacion);
        return "redirect:/parqueo/inicio";
    }
}
