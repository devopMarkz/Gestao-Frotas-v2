package com.github.devopMarkz.gestao_frotas.controllers;

import com.github.devopMarkz.gestao_frotas.dtos.usuario.CreateUsuarioDTO;
import com.github.devopMarkz.gestao_frotas.dtos.usuario.UsuarioRespostaDTO;
import com.github.devopMarkz.gestao_frotas.services.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody CreateUsuarioDTO createUsuarioDTO){
        UsuarioRespostaDTO usuarioRespostaDTO = usuarioService.salvar(createUsuarioDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioRespostaDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
