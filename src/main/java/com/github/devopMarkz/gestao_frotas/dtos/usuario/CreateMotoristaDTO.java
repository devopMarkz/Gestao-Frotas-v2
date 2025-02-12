package com.github.devopMarkz.gestao_frotas.dtos.usuario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class CreateMotoristaDTO extends CreateUsuarioDTO{

    @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo deve conter apenas letras.")
    private String nome;

    private Boolean disponivel;

    @Pattern(regexp = "^[0-9]+$", message = "O campo deve conter apenas números.")
    private String cnh;

    @Pattern(regexp = "^[A-E]$", message = "O campo deve conter apenas uma letra entre A e E.")
    private String categoriaCNH;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    public CreateMotoristaDTO(String email, String password, String tipoDeUsuario, String nome, Boolean disponivel, String cnh, String categoriaCNH, LocalDate dataNascimento) {
        super(email, password, tipoDeUsuario);
        this.nome = nome;
        this.disponivel = disponivel;
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.dataNascimento = dataNascimento;
    }

    public @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo deve conter apenas letras.") String getNome() {
        return nome;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public @Pattern(regexp = "^[0-9]+$", message = "O campo deve conter apenas números.") String getCnh() {
        return cnh;
    }

    public @Pattern(regexp = "^[A-E]$", message = "O campo deve conter apenas uma letra entre A e E.") String getCategoriaCNH() {
        return categoriaCNH;
    }

    public @Past @NotNull LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
