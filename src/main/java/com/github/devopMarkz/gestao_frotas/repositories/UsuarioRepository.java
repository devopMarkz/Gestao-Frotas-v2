package com.github.devopMarkz.gestao_frotas.repositories;

import com.github.devopMarkz.gestao_frotas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
