package com.spring.spring.caixa.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "caixas")
public class CaixaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "caixa", nullable = false, length = 60, unique = true)
    private String caixa;
    @Column(name = "saldo", nullable = false)
    private float saldo;

    @OneToMany(mappedBy = "caixa")
    @JsonManagedReference
    private List<CaixaMovEntity> movimentacoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public List<CaixaMovEntity> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<CaixaMovEntity> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

}
