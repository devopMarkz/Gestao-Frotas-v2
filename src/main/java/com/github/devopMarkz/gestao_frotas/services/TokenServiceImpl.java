package com.github.devopMarkz.gestao_frotas.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.github.devopMarkz.gestao_frotas.dtos.AuthDTO;
import com.github.devopMarkz.gestao_frotas.entities.Usuario;
import com.github.devopMarkz.gestao_frotas.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenServiceImpl {

    private final UsuarioRepository usuarioRepository;

    public TokenServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public String obterToken(AuthDTO authDTO){
        var usuario = usuarioRepository.findByEmail(authDTO.email())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente."));
        return gerarToken(usuario);
    }

    private String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("gestao_frota-api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(Instant.now().plus(8, ChronoUnit.HOURS))
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new IllegalArgumentException("Erro ao gerar token.");
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.require(algorithm)
                    .withIssuer("gestao_frota-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e){
            throw new IllegalArgumentException("Token inválido.");
        }
    }

}
