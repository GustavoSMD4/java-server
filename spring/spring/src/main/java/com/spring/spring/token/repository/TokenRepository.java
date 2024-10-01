package com.spring.spring.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.token.entity.TokenEntity;
import com.spring.spring.usuario.entity.UsuarioEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long>{
    
    TokenEntity findByUsuario(UsuarioEntity usuario);

}
