package com.tienda_v2.service;


import com.tienda_v2.domain.Ubicaciones;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UbicacionesService {
    public List<Ubicaciones> getUbicaciones();
    
    public Ubicaciones getUbicaciones(Ubicaciones ubicaciones);
    
    public void deleteUbicaciones(Ubicaciones ubicaciones);
    
    public void saveUbicaciones(Ubicaciones ubicaciones);
}
