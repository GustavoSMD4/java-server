package com.spring.spring.caixa.service;

import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.caixa.repository.CaixaTipoMovRepository;

@Service
public class CaixaTipoMovService extends ServiceAbstract<CaixaTipoMovEntity, Long> {

    public CaixaTipoMovService(CaixaTipoMovRepository repository) {
        super(repository);
    }

}
