package com.spring.spring.caixa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.caixa.entity.CaixaMovEntity;
import com.spring.spring.caixa.repository.CaixaMovRepository;

@Service
public class CaixaMovService {
    private CaixaMovRepository repository;

    
    public CaixaMovService(CaixaMovRepository repository) {
        this.repository = repository;
    }

    public List<CaixaMovEntity> consultarTodos() {
        return repository.findAll();
    }

    public CaixaMovEntity consultarPorId(long id) throws Exception {
        Optional<CaixaMovEntity> mov = repository.findById(id);

        if (!mov.isPresent()) {
            throw new Exception("Movimentação não localizada!");
        }

        return mov.get();
    }

    public List<CaixaMovEntity> create(CaixaMovEntity mov) {
        repository.save(mov);
        return repository.findAll();
    }

    public List<CaixaMovEntity> update(CaixaMovEntity mov) {
        repository.save(mov);
        return repository.findAll();
    }

    public List<CaixaMovEntity> delete(long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}
