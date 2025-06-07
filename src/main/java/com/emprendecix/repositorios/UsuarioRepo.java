package com.emprendecix.repositorios;

import com.emprendecix.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    List<Usuario> findAll();
    Usuario findByNombreUsuario(String nombreUsuario);
    List<Usuario> findByRol(String rol);
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.emprendedor WHERE u.id = :id")
    Usuario findByIdWithEmprendedor(@Param("id") Long id);
}
