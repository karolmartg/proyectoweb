package com.tienda_v2.dao;


import com.tienda_v2.domain.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionesDao extends JpaRepository<Ubicaciones, Long> {
    
}
