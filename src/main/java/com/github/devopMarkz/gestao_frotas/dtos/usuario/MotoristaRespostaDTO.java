package com.github.devopMarkz.gestao_frotas.dtos.usuario;

import java.time.LocalDate;

public class MotoristaRespostaDTO extends UsuarioRespostaDTO {

    private String nome;
    private Boolean disponivel;
    private String cnh;
    private String categoriaCNH;
    private LocalDate dataNascimento;

    public MotoristaRespostaDTO(Long id, String email, String tipoUsuario, String nome, Boolean disponivel, String cnh, String categoriaCNH, LocalDate dataNascimento) {
        super(id, email, tipoUsuario);
        this.nome = nome;
        this.disponivel = disponivel;
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public String getCnh() {
        return cnh;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
