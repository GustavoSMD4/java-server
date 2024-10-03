package com.spring.spring.server.caixa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.server.caixa.entity.CaixaEntity;
import com.spring.spring.server.caixa.entity.CaixaMovEntity;

public interface CaixaMovRepository extends JpaRepository<CaixaMovEntity, Long>{

    List<CaixaMovEntity> findAllByCaixa(CaixaEntity caixa);
    
}
