package com.lab.domains;

import com.lab.domains.enums.StatusCpf;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_funcionario")
    private Integer id;

    @NotBlank
    @NotNull
    private String nome;

    @NotNull
    @Digits(integer = 15, fraction = 2) // Validação para valores monetários (até 15 dígitos antes da vírgula e 2 depois)
    private BigDecimal salario;

    @NotBlank
    @NotNull
    private String cpf;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="status")
    private StatusCpf status;

    // Construtor padrão
    public Funcionario() {
        this.status = StatusCpf.DISPONIVEL; // Definindo um status padrão
    }

    // Construtor com parâmetros
    public Funcionario(Integer id, String nome, BigDecimal salario, String cpf, StatusCpf status) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.status = status;
    }

    // Getters e Setters
    public StatusCpf getStatus() {
        return status;
    }

    public void setStatus(StatusCpf status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Métodos equals() e hashCode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
