package com.github.devopMarkz.gestao_frotas.dtos.usuario;

public class UsuarioRespostaDTO {

    private Long id;
    private String email;
    private String tipoUsuario;

    public UsuarioRespostaDTO(Long id, String email, String tipoUsuario) {
        this.id = id;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
