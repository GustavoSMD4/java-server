package com.spring.spring.caixa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.caixa.repository.CaixaTipoMovRepository;
import com.spring.spring.dto.caixa.CaixaTipoMovDTO;

@Service
public class CaixaTipoMovService extends ServiceAbstract<CaixaTipoMovEntity, Long> {
    private CaixaTipoMovRepository repository;

    public CaixaTipoMovService(CaixaTipoMovRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<CaixaTipoMovEntity> create(CaixaTipoMovDTO caixaTipoMovDTO){
        CaixaTipoMovEntity caixaTipoMovEntity = new CaixaTipoMovEntity();
        caixaTipoMovEntity.setDescricao(caixaTipoMovDTO.getDescricao());
        caixaTipoMovEntity.setEntrada(caixaTipoMovDTO.isEntrada());

        repository.save(caixaTipoMovEntity);
        return repository.findAll();
    }

    public List<CaixaTipoMovEntity> update(CaixaTipoMovDTO caixaTipoMovDTO){
        CaixaTipoMovEntity caixaTipoMovEntity = new CaixaTipoMovEntity();
        caixaTipoMovEntity.setId(caixaTipoMovDTO.getId());
        caixaTipoMovEntity.setDescricao(caixaTipoMovDTO.getDescricao());
        caixaTipoMovEntity.setEntrada(caixaTipoMovDTO.isEntrada());

        repository.save(caixaTipoMovEntity);
        return repository.findAll();
    }

}
