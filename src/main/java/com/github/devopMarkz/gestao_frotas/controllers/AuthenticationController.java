package com.github.devopMarkz.gestao_frotas.controllers;

import com.github.devopMarkz.gestao_frotas.dtos.AuthDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String autenticarUsuario(@RequestBody AuthDTO authDTO){
        var authentication = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.senha());
        authenticationManager.authenticate(authentication);
        return "Token . . .";
    }

}
