package com.emprendecix.servicios;

import com.emprendecix.Util.JwtUtil;
import com.emprendecix.dto.Login.LoginRequestDTO;
import com.emprendecix.dto.Login.LoginResponseDTO;
import com.emprendecix.modelos.Usuario;
import com.emprendecix.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServicio {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponseDTO login(LoginRequestDTO loginDTO) {
        Usuario usuario = usuarioRepo.findByNombreUsuario(loginDTO.getNombreUsuario());
        if (usuario != null && passwordEncoder.matches(loginDTO.getContrasena(), usuario.getContrasenaHash())) {
            String token = jwtUtil.generarToken(usuario.getNombreUsuario());
            return new LoginResponseDTO(token, usuario.getRol(), usuario.getNombreUsuario());
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
