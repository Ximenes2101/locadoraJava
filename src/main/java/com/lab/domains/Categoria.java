package com.lab.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.lab.domains.enums.StatusVeiculo;

import java.util.Objects;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
    @SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
    private Integer id;

    @NotBlank @NotNull
    private String nome;

    @NotBlank @NotNull
    private String descricao;

    @Enumerated(EnumType.ORDINAL)  // Isso faz o enum ser armazenado como um número inteiro (ORDINAL) ou string (STRING)
    private StatusVeiculo status;

    // Construtor padrão, com inicialização de status
    public Categoria() {
        this.status = StatusVeiculo.DISPONIVEL;
    }

    // Construtor com todos os parâmetros
    public Categoria(Integer id, String nome, String descricao, StatusVeiculo status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    // Métodos equals e hashCode, com base em id, nome e descricao
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) &&
                Objects.equals(nome, categoria.nome) &&
                Objects.equals(descricao, categoria.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao);
    }
}
