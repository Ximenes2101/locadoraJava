package com.lab.domains;

import java.time.LocalDate;
import java.util.Objects;

import com.lab.domains.enums.StatusVeiculo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Veiculo")
    private Integer id;

    @NotBlank    @NotNull
    private String modelo;

    @NotBlank    @NotNull
    private String marca;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate ano;

    @NotBlank    @NotNull
    private String categoria;

    @NotBlank    @NotNull
    private String placa;


    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="status")
    private StatusVeiculo status;


    public Veiculo(){
        this.status = StatusVeiculo.DISPONIVEL;
    }


    public Veiculo(Integer id, String modelo, String marca, LocalDate ano, String categoria, String placa, StatusVeiculo status) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.categoria = categoria;
        this.placa = placa;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(marca, veiculo.marca) && Objects.equals(ano, veiculo.ano) && Objects.equals(categoria, veiculo.categoria) && status == veiculo.status && Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, marca, ano, categoria, status, placa);
    }
}
