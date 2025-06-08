package com.emprendecix.modelos;

import com.emprendecix.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuario", schema = "sc_promemprendedores")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usua_id")
    private Long id;

    @Column(name = "usua_nombre_usuario", nullable = false, unique = true, length = 100)
    private String nombreUsuario;

    @JsonIgnore
    @Column(name = "usua_contrasena_hash", nullable = false)
    private String contrasenaHash;

    @Column(name = "usua_rol", nullable = false, length = 20)
    private String rol; // ADMIN o EMPRENDEDOR

    @Column(name = "usua_empr_id")
    private Long emprendedorId;

    @Column(name = "usua_fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Relación con emprendedor (opcional) - ahora que existe la entidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usua_empr_id",
            referencedColumnName = "empr_id",
            insertable = false,
            updatable = false
    )
    private Emprendedor emprendedor;

    // Método para obtener solo datos básicos (DTO)
    public UsuarioDTO toDTO() {
        return new UsuarioDTO(
                this.id,
                this.nombreUsuario,
                this.rol,
                this.emprendedorId,
                this.fechaCreacion,
                this.emprendedor != null ? this.emprendedor.getNombres() + " " + this.emprendedor.getApellidos() : null
        );
    }
}
