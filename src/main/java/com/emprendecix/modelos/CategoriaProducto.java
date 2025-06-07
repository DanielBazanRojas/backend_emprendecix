package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_categoria_producto", schema = "sc_promemprendedores")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capr_id")
    private Long id;

    @Column(name = "capr_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "capr_descripcion")
    private String descripcion;
}
