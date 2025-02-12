package com.github.devopMarkz.gestao_frotas.services;

import com.github.devopMarkz.gestao_frotas.dtos.usuario.CreateUsuarioDTO;
import com.github.devopMarkz.gestao_frotas.dtos.usuario.UsuarioRespostaDTO;
import com.github.devopMarkz.gestao_frotas.entities.Usuario;
import com.github.devopMarkz.gestao_frotas.entities.enums.TipoUsuario;
import com.github.devopMarkz.gestao_frotas.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioRespostaDTO salvar(CreateUsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(null, usuarioDTO.getEmail(), passwordEncoder.encode(usuarioDTO.getSenha()), TipoUsuario.valueOf(usuarioDTO.getTipoUsuario()));
        var novoUsuario = usuarioRepository.save(usuario);
        return new UsuarioRespostaDTO(novoUsuario.getId(), novoUsuario.getEmail(), novoUsuario.getTipoUsuario().name());
    }
}
