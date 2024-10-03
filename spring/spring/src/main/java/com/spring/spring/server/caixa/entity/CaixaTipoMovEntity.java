package com.spring.spring.server.caixa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "caixa_tipos_movs")
public class CaixaTipoMovEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "descricao", nullable = false, length = 60, unique = true)
    private String descricao;
    @Column(name = "entrada", nullable = false)
    private boolean entrada;

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
