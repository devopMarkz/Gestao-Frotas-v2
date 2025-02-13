package com.github.devopMarkz.gestao_frotas.dtos.usuario;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipoUsuario", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateMotoristaDTO.class, name = "ROLE_MOTORISTA"),
        @JsonSubTypes.Type(value = CreateUsuarioDTO.class, name = "ROLE_ADMINISTRADOR")
})
public class CreateUsuarioDTO {

    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Size(min = 8, message = "Senha precisa conter no mínimo 8 dígitos.")
    private String senha;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo deve conter apenas letras.")
    private String tipoUsuario;

    public CreateUsuarioDTO(String email, String password, String tipoDeUsuario) {
        this.email = email;
        this.senha = password;
        this.tipoUsuario = tipoDeUsuario;
    }

    public @Email(message = "Formato de e-mail inválido.") String getEmail() {
        return email;
    }

    public @Size(min = 8, message = "Senha precisa conter no mínimo 8 dígitos.") String getSenha() {
        return senha;
    }

    public @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo deve conter apenas letras.") String getTipoUsuario() {
        return tipoUsuario;
    }
}
