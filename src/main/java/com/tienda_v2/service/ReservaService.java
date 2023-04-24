package com.tienda_v2.service;

import com.tienda_v2.domain.Reserva;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ReservaService {
    public List<Reserva> getReservas();
    
    public Reserva getReserva(Reserva reserva);
    
    public void deleteReserva(Reserva reserva);
    
    public void saveReserva(Reserva reserva);
}
