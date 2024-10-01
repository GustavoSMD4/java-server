package com.spring.spring.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.usuario.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    
}
