package com.spring.spring.server.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.server.caixa.entity.CaixaMovEntity;

public interface CaixaMovRepository extends JpaRepository<CaixaMovEntity, Long>{
    
}
