package com.tienda_v2.service.impl;

import com.tienda_v2.dao.UbicacionesDao;
import com.tienda_v2.domain.Ubicaciones;
import com.tienda_v2.service.UbicacionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UbicacionesServiceImpl implements UbicacionesService {

    @Autowired
    private UbicacionesDao ubicacionesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ubicaciones> getUbicaciones() {
        return (List<Ubicaciones>) ubicacionesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ubicaciones getUbicaciones(Ubicaciones ubicaciones) {
        return ubicacionesDao.findById(ubicaciones.getIdUbicacion()).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUbicaciones(Ubicaciones ubicaciones) {
        ubicacionesDao.delete(ubicaciones);
    }

    @Override
    public void saveUbicaciones(Ubicaciones ubicaciones) {
        ubicacionesDao.save(ubicaciones);
    }
}
