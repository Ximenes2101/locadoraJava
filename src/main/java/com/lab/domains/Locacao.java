package com.lab.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locacao")
    @SequenceGenerator(name = "seq_locacao", sequenceName = "seq_locacao", allocationSize = 1)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorTotal;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")  // Define a chave estrangeira para Cliente
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")  // Define a chave estrangeira para Veículo
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")  // Define a chave estrangeira para Funcionário
    private Funcionario funcionario;

    // Construtor sem parâmetros necessário para o JPA
    public Locacao() {
        // Construtor vazio para permitir a criação da entidade pelo JPA
    }

    // Construtor com todos os parâmetros necessários
    public Locacao(Integer id, boolean ativo, LocalDate dataInicio, LocalDate dataFim, BigDecimal valorTotal, Cliente cliente, Veiculo veiculo, Funcionario funcionario) {
        this.id = id;
        this.ativo = ativo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Locacao locacao = (Locacao) o;
        return Objects.equals(id, locacao.id) &&
                Objects.equals(dataInicio, locacao.dataInicio) &&
                Objects.equals(dataFim, locacao.dataFim) &&
                Objects.equals(valorTotal, locacao.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInicio, dataFim, valorTotal);
    }
}
