package com.tienda_v2.service;

import com.tienda_v2.domain.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    //Se recupera una lista con todos los registros de la tabla cliente
    public List<Usuario> getUsuarios();
    
    //Se recupera el registro que tiene el idCliente pasado por parámetro
    //si no existe en la tabla se retorna null
    public Usuario getUsuario(Usuario usuario);
    
    //Se elimina el registro que tiene el idCliente pasado por parámetro
    public void deleteUsuario(Usuario usuario);
    
    //Si el objeto cliente tiene un idCliente que existe en la tabla cliente
    //El registro de actualiza con la nueva información
    //Si el idCliente NO existe en la tabla, se crea el registro con esa información
    public void saveUsuario(Usuario usuario);
    
   public boolean findByUsername(String username, String passw);
    
}
