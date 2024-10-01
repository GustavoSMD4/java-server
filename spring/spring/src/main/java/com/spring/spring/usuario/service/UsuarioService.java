package com.spring.spring.usuario.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spring.spring.dto.UsuarioDTO;
import com.spring.spring.role.entity.RoleEntity;
import com.spring.spring.role.service.RoleService;
import com.spring.spring.token.entity.TokenEntity;
import com.spring.spring.token.service.TokenService;
import com.spring.spring.usuario.entity.UsuarioEntity;
import com.spring.spring.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private UsuarioRepository repository;
    private RoleService roleService;
    private TokenService tokenService;

    public UsuarioService(UsuarioRepository repository, RoleService roleService, TokenService tokenService) {
        this.repository = repository;
        this.roleService = roleService;
        this.tokenService = tokenService;
    }

    public List<UsuarioEntity> consultarTodos() {
        return repository.findAll();
    }

    public Optional<UsuarioEntity> consultarPorId(long id) {
        return repository.findById(id);
    }

    public List<UsuarioEntity> create(UsuarioDTO usuario) throws Exception {
        Optional<RoleEntity> role = roleService.consultarPorId(usuario.getIdRole());

        if (!role.isPresent()) {
            throw new Exception("Role não encontrado!");
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        TokenEntity tokenEntity = new TokenEntity();

        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setUsuario(usuario.getUsuario());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setRole(role.get());

        UsuarioEntity usuarioSalvo = repository.save(usuarioEntity);

        tokenEntity.setUsuario(usuarioSalvo);
        tokenEntity.setToken(UUID.randomUUID().toString());
        TokenEntity tokenCriado = tokenService.create(tokenEntity);

        usuarioSalvo.setToken(tokenCriado);
        repository.save(usuarioSalvo);
        return repository.findAll();
    }

    public List<UsuarioEntity> update(UsuarioDTO usuario) throws Exception {
        if (usuario.getId() == 0) {
            throw new Exception("Id vazio!");
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        Optional<RoleEntity> role = roleService.consultarPorId(usuario.getIdRole());

        if (!role.isPresent()) {
            throw new Exception("Role não encontrado!");
        }

        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setUsuario(usuario.getUsuario());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setRole(role.get());

        repository.save(usuarioEntity);
        return repository.findAll();
    }

    public List<UsuarioEntity> delete(long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}