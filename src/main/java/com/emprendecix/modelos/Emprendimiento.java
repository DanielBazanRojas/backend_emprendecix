package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_emprendimiento", schema = "sc_promemprendedores")
public class Emprendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empo_empr_id", referencedColumnName = "empr_id", nullable = false)
    private Emprendedor emprendedor;

    @Column(name = "empo_nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "empo_descripcion")
    private String descripcion;

    @Column(name = "empo_rubro", length = 100)
    private String rubro;

    @Column(name = "empo_ubicacion")
    private String ubicacion;

    @Column(name = "empo_fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "empo_estado_verificacion")
    private Boolean estadoVerificacion;
}
