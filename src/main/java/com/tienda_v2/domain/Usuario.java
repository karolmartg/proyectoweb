package com.tienda_v2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @Column(name="cedula", nullable = false)
    private String cedula;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name="contraseña", nullable = false)
    private String contraseña;

    public Usuario(String cedula, String nombre, String username, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.username = username;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }    
}
