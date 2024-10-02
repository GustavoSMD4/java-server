package com.spring.spring.caixa.service;

import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.caixa.entity.CaixaMovEntity;
import com.spring.spring.caixa.repository.CaixaMovRepository;

@Service
public class CaixaMovService extends ServiceAbstract<CaixaMovEntity, Long> {

    public CaixaMovService(CaixaMovRepository repository) {
        super(repository);
    }

}
