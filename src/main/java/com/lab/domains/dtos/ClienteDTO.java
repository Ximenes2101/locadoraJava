package com.lab.domains.dtos;

import com.lab.domains.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public class ClienteDTO {

    @NotNull(message = "O campo CPF não pode ser nulo")
    @NotBlank(message = "O campo CPF não pode estar vazio")
    private String cpf;

    @NotNull(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotNull(message = "O campo endereço não pode ser nulo")
    private String endereco;

    @NotNull(message = "O campo telefone não pode ser nulo")
    private String telefone;

    // Construtor sem argumentos necessário para a deserialização
    public ClienteDTO() {
    }

    // Construtor que converte um Cliente em ClienteDTO
    public ClienteDTO(Cliente cliente) {
        if (cliente != null) {
            this.nome = cliente.getNome();
            this.cpf = cliente.getCpf();
            this.endereco = cliente.getEndereco();
            this.telefone = cliente.getTelefone();
        }
    }

    public ClienteDTO(Optional<Cliente> obj) {
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo CPF não pode ser nulo") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo CPF não pode ser nulo") String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
