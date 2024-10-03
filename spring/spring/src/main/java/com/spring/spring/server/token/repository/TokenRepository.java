package com.spring.spring.server.token.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.server.token.entity.TokenEntity;
import com.spring.spring.server.usuario.entity.UsuarioEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long>{
    
    TokenEntity findByUsuario(UsuarioEntity usuario);

    Optional<TokenEntity> findByToken(String token);

    void deleteByUsuario(UsuarioEntity usuario);

}
