package com.spring.spring.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.caixa.entity.CaixaEntity;

public interface CaixaRepository extends JpaRepository<CaixaEntity, Long>{
    
}
