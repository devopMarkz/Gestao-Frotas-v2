package com.github.devopMarkz.gestao_frotas.entities;

import com.github.devopMarkz.gestao_frotas.entities.enums.CategoriaCNH;
import com.github.devopMarkz.gestao_frotas.entities.enums.TipoUsuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Usuario {

    @Column(nullable = false)
    private String nome;

    private Boolean disponivel = true;

    @Column(unique = true, nullable = false)
    private String cnh;

    @Enumerated(EnumType.STRING)
    private CategoriaCNH categoriaCNH;

    private LocalDate dataNascimento;

    public Motorista() {}

    public Motorista(Long id, String email, String senha, String nome, String cnh, CategoriaCNH categoriaCNH, LocalDate dataNascimento) {
        super(id, email, senha, TipoUsuario.MOTORISTA);
        this.nome = nome;
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public CategoriaCNH getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Motorista motorista = (Motorista) object;
        return Objects.equals(cnh, motorista.cnh);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnh);
    }
}
