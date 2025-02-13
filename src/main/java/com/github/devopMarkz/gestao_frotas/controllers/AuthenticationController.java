package com.github.devopMarkz.gestao_frotas.controllers;

import com.github.devopMarkz.gestao_frotas.dtos.AuthDTO;
import com.github.devopMarkz.gestao_frotas.services.TokenServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticar Usuário", description = "Endpoint para autenticar usuário e receber Token JWT")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenServiceImpl tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenServiceImpl tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    @Operation(summary = "Endpoint de autenticação", description = "Autentica usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário autenticado."),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado.")
    })
    public String autenticarUsuario(@RequestBody AuthDTO authDTO){
        var authentication = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.senha());
        authenticationManager.authenticate(authentication);
        return tokenService.obterToken(authDTO);
    }

}
