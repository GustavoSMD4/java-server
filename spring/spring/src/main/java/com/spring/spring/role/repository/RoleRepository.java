package com.spring.spring.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.role.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
    
}
