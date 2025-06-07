package com.emprendecix.controladores;

import com.emprendecix.dto.UsuarioDTO;
import com.emprendecix.modelos.Usuario;
import com.emprendecix.repositorios.UsuarioRepo;
import com.emprendecix.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // Obtener todos los usuarios con datos básicos
    @GetMapping
    public List<UsuarioDTO> obtenerTodosUsuarios() {
        return usuarioServicio.obtenerTodosUsuarios();
    }

    // Obtener usuario por ID con datos extendidos
    @GetMapping("/{id}/detalle")
    public Usuario obtenerUsuarioDetalle(@PathVariable Long id) {
        return usuarioServicio.obtenerUsuarioDetalle(id);
    }

    // Obtener usuarios por rol
    @GetMapping("/rol/{rol}")
    public List<Usuario> obtenerUsuariosPorRol(@PathVariable String rol) {
        return usuarioServicio.obtenerUsuariosPorRol(rol);
    }

    // Obtener usuario por nombre de usuario
    @GetMapping("/nombre/{nombreUsuario}")
    public Usuario obtenerUsuarioPorNombre(@PathVariable String nombreUsuario) {
        return usuarioServicio.obtenerUsuarioPorNombre(nombreUsuario);
    }

}
