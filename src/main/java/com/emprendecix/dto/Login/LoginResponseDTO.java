package com.emprendecix.dto.Login;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private String rol;
    private String nombreUsuario;

    public LoginResponseDTO(String token, String rol, String nombreUsuario) {
        this.token = token;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
    }
}
