package com.spring.spring.caixa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.caixa.entity.CaixaMovEntity;
import com.spring.spring.caixa.repository.CaixaMovRepository;

@Service
public class CaixaMovService extends ServiceAbstract<CaixaMovEntity, Long> {
    private CaixaMovRepository repository;

    public CaixaMovService(CaixaMovRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<CaixaMovEntity> create(){}

}
