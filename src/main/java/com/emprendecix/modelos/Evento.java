package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_evento", schema = "sc_promemprendedores")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "even_id")
    private Long id;

    @Column(name = "even_nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "even_descripcion")
    private String descripcion;

    @Column(name = "even_fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "even_fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "even_ubicacion")
    private String ubicacion;

    @Column(name = "even_aforo_maximo")
    private Integer aforoMaximo;
}
