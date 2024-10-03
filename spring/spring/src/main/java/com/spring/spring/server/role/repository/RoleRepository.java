package com.spring.spring.server.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.server.role.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
    
}
