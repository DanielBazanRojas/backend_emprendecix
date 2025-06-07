package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_participacion_evento", schema = "sc_promemprendedores")
public class ParticipacionEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paev_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paev_even_id", nullable = false)
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paev_empo_id", nullable = false)
    private Emprendimiento emprendimiento;

    @Column(name = "paev_codigo_qr", nullable = false)
    private String codigoQr;

    @Column(name = "paev_estado_asistencia")
    private Boolean estadoAsistencia;

    @Column(name = "paev_fecha_registro")
    private LocalDateTime fechaRegistro;
}
