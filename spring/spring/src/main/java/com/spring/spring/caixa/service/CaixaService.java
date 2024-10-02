package com.spring.spring.caixa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.caixa.entity.CaixaEntity;
import com.spring.spring.caixa.repository.CaixaRepository;
import com.spring.spring.dto.caixa.CaixaDTO;

@Service
public class CaixaService extends ServiceAbstract<CaixaEntity, Long> {
    private CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public List<CaixaEntity> create(CaixaDTO caixaDTO) {
        CaixaEntity caixaEntity = new CaixaEntity();

        caixaEntity.setCaixa(caixaDTO.getCaixa());
        caixaEntity.setSaldo(caixaDTO.getSaldo());

        caixaRepository.save(caixaEntity);
        return caixaRepository.findAll();
    }

}
