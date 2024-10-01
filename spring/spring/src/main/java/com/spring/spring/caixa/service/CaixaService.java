package com.spring.spring.caixa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.caixa.entity.CaixaEntity;
import com.spring.spring.caixa.repository.CaixaRepository;

@Service
public class CaixaService {
    private CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public List<CaixaEntity> consultarTodos() {
        return caixaRepository.findAll();
    }

    public CaixaEntity consultarPorId(long id) throws Exception {
        Optional<CaixaEntity> caixa = caixaRepository.findById(id);

        if (!caixa.isPresent()) {
            throw new Exception("Caixa não localizado!");
        }

        return caixa.get();
    }

    public List<CaixaEntity> create(CaixaEntity caixaEntity) {
        caixaRepository.save(caixaEntity);
        return caixaRepository.findAll();
    }

    public List<CaixaEntity> update(CaixaEntity caixaEntity) {
        caixaRepository.save(caixaEntity);
        return caixaRepository.findAll();
    }

    public List<CaixaEntity> delete(long id) {
        caixaRepository.deleteById(id);
        return caixaRepository.findAll();
    }

}
