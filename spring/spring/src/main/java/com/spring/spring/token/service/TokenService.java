package com.spring.spring.token.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.token.entity.TokenEntity;
import com.spring.spring.token.repository.TokenRepository;

@Service
public class TokenService {
    private TokenRepository repository;

    public TokenService(TokenRepository repository) {
        this.repository = repository;
    }

    public List<TokenEntity> consultarTodos() {
        return repository.findAll();
    }

    public Optional<TokenEntity> consultarPorId(long id) {
        return repository.findById(id);
    }

    public TokenEntity create(TokenEntity token) {
        return repository.save(token);
    }

    public void update(TokenEntity token) {
        repository.save(token);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
