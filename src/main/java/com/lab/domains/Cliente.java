package com.lab.domains;

import com.lab.domains.enums.StatusCpf;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity  // Adicionando a anotação @Entity
@Table(name = "clientes")  // Opcional: Definindo o nome da tabela no banco de dados
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
    private Integer id;

    @NotBlank @NotNull
    private String cpf;

    @NotBlank @NotNull
    private String nome;

    @NotBlank @NotNull
    private String endereco;

    @NotBlank @NotNull
    private String telefone;

    @Enumerated(EnumType.ORDINAL)  // Mapear o status para a tabela
    @Column(name = "status")  // Definindo o nome da coluna do status no banco
    private StatusCpf status;

    public Cliente(){
        this.status = StatusCpf.DISPONIVEL;  // Atribuindo um valor padrão ao status
    }

    public Cliente(Integer id, String cpf, String nome, String endereco, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusCpf getStatus() {
        return status;
    }

    public void setStatus(StatusCpf status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
