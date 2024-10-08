package com.spring.spring.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceAbstract<Entidade, ID, Repository extends JpaRepository<Entidade, ID>> {
    
    @Autowired
    protected Repository repository;

    public List<Entidade> consultarTodos() {
        return repository.findAll();
    }

    public Entidade consultarPorId(ID id) throws Exception {
        Optional<Entidade> entidade = repository.findById(id);

        if (!entidade.isPresent()) {
            throw new Exception("Falha ao localizar por id: entidade não localizada!");
        }

        return entidade.get();
    }

    public List<Entidade> salvar(Entidade entidade){
        repository.save(entidade);
        return repository.findAll();
    }

    public List<Entidade> delete(ID id){
        repository.deleteById(id);
        return repository.findAll();
    }
}
