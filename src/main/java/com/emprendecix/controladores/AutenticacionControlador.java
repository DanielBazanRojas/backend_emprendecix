package com.emprendecix.controladores;

import com.emprendecix.Util.JwtUtil;
import com.emprendecix.modelos.Usuario;
import com.emprendecix.servicios.UsuarioServicio;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request, HttpServletResponse response) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasena())
            );

            Usuario usuario = usuarioServicio.obtenerUsuarioPorNombre(request.getUsuario());
            return jwtUtil.generarToken(usuario.getNombreUsuario());
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "Credenciales inválidas";
        }
    }

    @Data
    public static class LoginRequest {
        private String usuario;
        private String contrasena;
    }
}
