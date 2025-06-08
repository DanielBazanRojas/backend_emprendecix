package com.emprendecix.servicios;

import com.emprendecix.dto.UsuarioDTO;
import com.emprendecix.modelos.Usuario;
import com.emprendecix.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio implements UserDetailsService{
    @Autowired
    private UsuarioRepo usuarioRepository;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerTodosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(Usuario::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioDetalle(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerUsuariosPorRol(String rol) {
        return usuarioRepository.findByRol(rol.toUpperCase());
    }

    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);
        if (usuario == null) throw new UsernameNotFoundException("Usuario no encontrado");

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getNombreUsuario())
                .password(usuario.getContrasenaHash())
                .authorities(usuario.getRol())
                .build();
    }
}

