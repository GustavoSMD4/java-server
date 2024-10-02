package com.spring.spring.dto.caixa;

public class CaixaTipoMovDTO {
    private long id;
    private String descricao;
    private boolean entrada;

    public CaixaTipoMovDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

}
