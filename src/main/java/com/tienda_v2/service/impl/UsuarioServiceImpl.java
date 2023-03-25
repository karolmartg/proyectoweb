package com.tienda_v2.service.impl;

import com.tienda_v2.dao.UsuarioDao;
import com.tienda_v2.domain.Usuario;
import com.tienda_v2.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean findByUsername(String username, String passw) {
        List<Usuario> users = getUsuarios();

        // se recorre la lista de usuarios
        for (Usuario user : users) {
            // si el username y contraseña son correctos == true
            if (user.getUsername().equalsIgnoreCase(username) && user.getContraseña().contains(passw)) {
                return true;
            }
        }
        // sino encuentra nada retorna false
        return false;
    }
}
