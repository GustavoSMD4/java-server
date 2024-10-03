package com.spring.spring.server.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.server.caixa.entity.CaixaEntity;

public interface CaixaRepository extends JpaRepository<CaixaEntity, Long>{
    
}
