package com.tienda_v2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="reserva")
public class Reserva {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    
    @Column(name="id_usuario", nullable = false)
    private Long idUsuario;
    @Column(name="id_ubicacion", nullable = false)
    private Long idUbicacion;
    @Column(name="fecha_reserva", nullable = false)
    private String fechaReserva; // --> dateFormat.format(fechaReserva)
    @Column(name="tarjeta", nullable = false)
    private Integer tarjeta;
    @Column(name="precio", nullable = false)
    private Integer precio;
    @Column(name="activo", nullable = false)
    private Integer activo;
    
    // Constructor generico 
    public Reserva() {
    }
    
    // Constructor especifico
    public Reserva(Long idUsuario, Long idUbicacion, String fechaReserva, Integer tarjeta, Integer precio, Integer activo) {
        this.idUsuario = idUsuario;
        this.idUbicacion = idUbicacion;
        this.fechaReserva = fechaReserva;
        this.tarjeta = tarjeta;
        this.precio = precio;
        this.activo = activo;
    }
    
}
