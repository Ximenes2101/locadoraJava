package com.lab.domains.enums;

public enum StatusCpf {

        ALOCADO(0, "ATIVO"), DISPONIVEL(1, "INDISPONIVEL");

        private Integer id;
        private String situacao;


    StatusCpf(Integer id, String situacao) {
            this.id = id;
            this.situacao = situacao;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSituacao() {
            return situacao;
        }

        public void setSituacao(String situacao) {
            this.situacao = situacao;
        }


        public static com.lab.domains.enums.StatusCpf toEnum(Integer id) {
            if (id == null) return null;
            for (com.lab.domains.enums.StatusCpf x : com.lab.domains.enums.StatusCpf.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            throw new IllegalArgumentException("Status invalido");
        }
    }
