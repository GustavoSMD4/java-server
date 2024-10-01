package com.spring.spring.caixa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "caixa_movs")
public class CaixaMovEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "descricao", length = 60)
    private String descricao;
    @Column(name = "valor", nullable = false)
    private float valor;

    @ManyToOne
    @JoinColumn(name = "id_caixa")
    @JsonBackReference
    private CaixaEntity caixa;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    @JsonBackReference
    private CaixaTipoMovEntity tipo;

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

    public CaixaEntity getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaEntity caixa) {
        this.caixa = caixa;
    }

    public CaixaTipoMovEntity getTipo() {
        return tipo;
    }

    public void setTipo(CaixaTipoMovEntity tipo) {
        this.tipo = tipo;
    }

}
