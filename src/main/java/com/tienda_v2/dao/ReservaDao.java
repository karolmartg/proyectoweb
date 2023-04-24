package com.tienda_v2.dao;

import com.tienda_v2.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {
    
}
