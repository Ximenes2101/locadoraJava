package com.lab.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lab.domains.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VeiculoDTO {

    @NotNull(message = "O campo codigo do veículo não pode ser nulo")
    @NotBlank(message = "O campo codigo do veículo não pode estar vazio")
    private Integer id;

    @NotNull(message = "O campo modelo não pode ser nulo")
    private String modelo;

    @NotNull(message = "O campo marca não pode ser nulo")
    private String marca;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate ano;

    @NotNull(message = "O campo categoria não pode ser nulo")
    private String categoria;

    @NotNull(message = "O campo placa não pode ser nulo")
    private String placa;

    private int status;

    public VeiculoDTO(){}

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.modelo = veiculo.getModelo();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.categoria = veiculo.getCategoria();
        this.placa = veiculo.getPlaca();
        this.status = veiculo.getStatus().getId();
    }

    // Getter e Setter para 'id' (codigoVeiculo)
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
