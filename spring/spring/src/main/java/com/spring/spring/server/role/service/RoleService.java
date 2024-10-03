package com.spring.spring.server.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.server.role.entity.RoleEntity;
import com.spring.spring.server.role.repository.RoleRepository;

@Service
public class RoleService {
    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<RoleEntity> consultarTodos() {
        return repository.findAll();
    }

    public Optional<RoleEntity> consultarPorId(long id) {
        return repository.findById(id);
    }

    public List<RoleEntity> create(RoleEntity roleCreate) {
        repository.save(roleCreate);
        return repository.findAll();
    }

    public List<RoleEntity> update(RoleEntity roleUpdate) {
        repository.save(roleUpdate);
        return repository.findAll();
    }

    public List<RoleEntity> delete(long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}
