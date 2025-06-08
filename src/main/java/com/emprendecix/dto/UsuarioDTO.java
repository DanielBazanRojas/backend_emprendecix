package com.emprendecix.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String rol;
    private Long emprendedorId;
    private LocalDateTime fechaCreacion;
    private String nombreEmprendedor; // Nuevo campo

    // Constructor alternativo
    public UsuarioDTO(Long id, String nombreUsuario, String rol,
                      Long emprendedorId, LocalDateTime fechaCreacion,
                      String nombreEmprendedor) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.emprendedorId = emprendedorId;
        this.fechaCreacion = fechaCreacion;
        this.nombreEmprendedor = nombreEmprendedor;
    }
}
