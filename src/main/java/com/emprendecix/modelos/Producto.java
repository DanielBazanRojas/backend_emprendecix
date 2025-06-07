package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_producto", schema = "sc_promemprendedores")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_empo_id", nullable = false)
    private Emprendimiento emprendimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_catp_id", nullable = false)
    private CategoriaProducto categoria;

    @Column(name = "prod_nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "prod_descripcion")
    private String descripcion;

    @Column(name = "prod_imagen_url")
    private String imagenUrl;

    @Column(name = "prod_fecha_publicacion")
    private LocalDateTime fechaPublicacion;
}
