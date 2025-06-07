package com.emprendecix.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_emprendedor", schema = "sc_promemprendedores")
@Data

public class Emprendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empr_id")
    private Long id;

    @Column(name = "empr_dni", nullable = false, unique = true, length = 8)
    private String dni;

    @Column(name = "empr_nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "empr_apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "empr_correo", nullable = false, unique = true, length = 150)
    private String correo;

    @Column(name = "empr_telefono", length = 15)
    private String telefono;

    @Column(name = "empr_direccion")
    private String direccion;

    @Column(name = "empr_fecha_registro")
    private LocalDateTime fechaRegistro;
}
