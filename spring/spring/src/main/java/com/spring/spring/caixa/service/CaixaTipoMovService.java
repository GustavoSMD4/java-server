package com.spring.spring.caixa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.caixa.repository.CaixaTipoMovRepository;

@Service
public class CaixaTipoMovService {
    private CaixaTipoMovRepository repository;

    public CaixaTipoMovService(CaixaTipoMovRepository repository) {
        this.repository = repository;
    }

    public List<CaixaTipoMovEntity> consultarTodos() {
        return repository.findAll();
    }

    public CaixaTipoMovEntity consultarPorId(long id) throws Exception {
        Optional<CaixaTipoMovEntity> tipo = repository.findById(id);

        if (!tipo.isPresent()) {
            throw new Exception("Tipo não localizado!");
        }

        return tipo.get();
    }

    public List<CaixaTipoMovEntity> create(CaixaTipoMovEntity tipo) {
        repository.save(tipo);
        return repository.findAll();
    }

    public List<CaixaTipoMovEntity> update(CaixaTipoMovEntity tipo) {
        repository.save(tipo);
        return repository.findAll();
    }

    public List<CaixaTipoMovEntity> delete(long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}
