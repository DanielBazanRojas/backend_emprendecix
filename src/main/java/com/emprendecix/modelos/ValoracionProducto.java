package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_valoracion_producto", schema = "sc_promemprendedores")
public class ValoracionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vapr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vapr_prod_id", nullable = false)
    private Producto producto;

    @Column(name = "vapr_puntaje")
    private Integer puntaje;

    @Column(name = "vapr_fecha")
    private LocalDateTime fecha;
}
