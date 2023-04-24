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
@Table(name="ubicacion")
public class Ubicaciones {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;
    
    @Column(name="id_promocion", nullable = false)
    private Long idPromocion;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="ubicacion_exacta", nullable = false)
    private String ubicacionexacta;
    @Column(name="espacios_totales", nullable = false)
    private Integer espaciosTotales;
    @Column(name="espacios_disponibles", nullable = false)
    private Integer espaciosDisponibles;
    @Column(name="imagen_link", nullable = false)
    private String imagen_link;
    
    
    // Constructor generico 
    public Ubicaciones() {
    }
    
    // Constructor especifico
    public Ubicaciones(Long idPromocion, String nombre, String ubicacionexacta, Integer espaciosTotales, Integer espaciosDisponibles, String imagen_link) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
        this.ubicacionexacta = ubicacionexacta;
        this.espaciosTotales = espaciosTotales;
        this.espaciosDisponibles = espaciosDisponibles;
        this.imagen_link = imagen_link;
    }

    
    
    
}
