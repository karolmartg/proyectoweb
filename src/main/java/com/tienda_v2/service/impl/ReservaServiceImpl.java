package com.tienda_v2.service.impl;

import com.tienda_v2.dao.ReservaDao;
import com.tienda_v2.domain.Reserva;
import com.tienda_v2.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservas() {
        return (List<Reserva>) reservaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdFactura()).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteReserva(Reserva reserva) {
        reservaDao.delete(reserva);
    }

    @Override
    public void saveReserva(Reserva reserva) {
        reservaDao.save(reserva);
    }
}
