package com.github.devopMarkz.gestao_frotas.configs;

import com.github.devopMarkz.gestao_frotas.entities.Usuario;
import com.github.devopMarkz.gestao_frotas.repositories.UsuarioRepository;
import com.github.devopMarkz.gestao_frotas.services.TokenServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthenticationJwtFilter extends OncePerRequestFilter {

    private final UsuarioRepository usuarioRepository;
    private final TokenServiceImpl tokenService;

    public AuthenticationJwtFilter(UsuarioRepository usuarioRepository, TokenServiceImpl tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extraiTokendoHeader(request);

        if(token != null){
            String login = tokenService.validarToken(token);
            Usuario usuario = usuarioRepository.findByEmail(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
            var authenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

    private String extraiTokendoHeader(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");

        if(authHeader == null){
            return null;
        }

        if(!authHeader.split(" ")[0].equals("Bearer")){
            return null;
        }

        return authHeader.split(" ")[1];
    }

}
