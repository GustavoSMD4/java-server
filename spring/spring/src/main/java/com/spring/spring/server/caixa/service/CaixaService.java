package com.spring.spring.server.caixa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.dto.caixa.CaixaDTO;
import com.spring.spring.server.caixa.entity.CaixaEntity;
import com.spring.spring.server.caixa.repository.CaixaRepository;

@Service
public class CaixaService extends ServiceAbstract<CaixaEntity, Long, CaixaRepository> {

    public List<CaixaEntity> create(CaixaDTO caixaDTO) {
        CaixaEntity caixaEntity = new CaixaEntity();

        caixaEntity.setCaixa(caixaDTO.getCaixa());
        caixaEntity.setSaldo(caixaDTO.getSaldo());

        repository.save(caixaEntity);
        return repository.findAll();
    }

}
