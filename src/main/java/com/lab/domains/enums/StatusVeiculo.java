package com.lab.domains.enums;

public enum StatusVeiculo {
    DISPONIVEL(1),
    LOCADO(2),
    MANUTENCAO(3);

    private final int id;

    StatusVeiculo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static StatusVeiculo fromId(int id) {
        for (StatusVeiculo status : StatusVeiculo.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status não encontrado para o id " + id);
    }
}
