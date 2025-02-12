package com.github.devopMarkz.gestao_frotas.services;

import com.github.devopMarkz.gestao_frotas.dtos.usuario.CreateUsuarioDTO;
import com.github.devopMarkz.gestao_frotas.dtos.usuario.UsuarioRespostaDTO;
import com.github.devopMarkz.gestao_frotas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioRespostaDTO salvar(CreateUsuarioDTO usuarioDTO){

        return null;
    }
}
