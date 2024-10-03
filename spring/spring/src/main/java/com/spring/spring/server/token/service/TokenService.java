package com.spring.spring.server.token.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.server.token.entity.TokenEntity;
import com.spring.spring.server.token.repository.TokenRepository;
import com.spring.spring.server.usuario.entity.UsuarioEntity;
import com.spring.spring.server.usuario.repository.UsuarioRepository;

@Service
public class TokenService {
    private TokenRepository repository;
    private UsuarioRepository usuarioRepository;

    public TokenService(TokenRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
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

    public void deleteByUsuario(UsuarioEntity usuarioEntity){
        repository.deleteByUsuario(usuarioEntity);
    }

    public UsuarioEntity validarToken(String auth) throws Exception {
        if (auth == null || !auth.startsWith("Bearer ")) {
            throw new Exception("Token de autorização inválido!");
        }

        String token = auth.substring(7);
        Optional<TokenEntity> tokenEntity = repository.findByToken(token);

        if (!tokenEntity.isPresent()) {
            throw new Exception("Token não localizado");
        }

        Optional<UsuarioEntity> usuario = usuarioRepository.findById(tokenEntity.get().getUsuario().getId());

        if (!usuario.isPresent()) {
            throw new Exception("Usuário não localizado!");
        }

        return usuario.get();

    }
}
