package com.spring.spring.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.usuario.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    
    Optional<UsuarioEntity> findByUsuario(String usuario);

}
