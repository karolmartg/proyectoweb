package com.tienda_v2.controller;

import com.tienda_v2.dao.ReservaDao;
import com.tienda_v2.domain.Reserva;
import com.tienda_v2.domain.Usuario;
import com.tienda_v2.service.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ReservaController {

    @Autowired
    ReservaService reservaService;
    @Autowired
    ReservaDao reservaDao;

    @GetMapping("/reservas")
    public String inicio(Model model) {
        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        return "/usuario/mis-reservas";
    }
}
