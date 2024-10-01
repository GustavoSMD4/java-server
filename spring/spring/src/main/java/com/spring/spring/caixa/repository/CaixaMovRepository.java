package com.spring.spring.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.caixa.entity.CaixaMovEntity;

public interface CaixaMovRepository extends JpaRepository<CaixaMovEntity, Long>{
    
}
