package com.lab.domains.dtos;

import com.lab.domains.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaDTO {

    @NotNull(message = "O campo código não pode ser nulo")
    private Integer codigo;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;  // Corrigido de discricao para descricao

    // Construtor padrão
    public CategoriaDTO() {}

    // Construtor que recebe uma Categoria
    public CategoriaDTO(Categoria categoria) {
        this.codigo = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();  // Corrigido de discricao para descricao
    }

    // Getters e Setters

    public @NotNull(message = "O campo código não pode ser nulo") Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(@NotNull(message = "O campo código não pode ser nulo") Integer codigo) {
        this.codigo = codigo;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }
}
