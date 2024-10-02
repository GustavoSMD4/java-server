package com.spring.spring.dto.caixa;

public class CaixaMovDTO {
    private long id;
    private long idCaixa;
    private long idTipo;
    private String descricao;
    private float valor;

    public CaixaMovDTO() {

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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public long getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(long idCaixa) {
        this.idCaixa = idCaixa;
    }

    public long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

}
