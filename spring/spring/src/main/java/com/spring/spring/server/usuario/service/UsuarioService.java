package com.spring.spring.server.usuario.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.dto.LoginDTO;
import com.spring.spring.dto.UsuarioDTO;
import com.spring.spring.server.role.entity.RoleEntity;
import com.spring.spring.server.role.service.RoleService;
import com.spring.spring.server.token.entity.TokenEntity;
import com.spring.spring.server.token.service.TokenService;
import com.spring.spring.server.usuario.entity.UsuarioEntity;
import com.spring.spring.server.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService extends ServiceAbstract<UsuarioEntity, Long, UsuarioRepository> {
    private RoleService roleService;
    private TokenService tokenService;

    public UsuarioService(RoleService roleService, TokenService tokenService) {
        this.roleService = roleService;
        this.tokenService = tokenService;
    }

    public UsuarioEntity login(LoginDTO loginDTO) throws Exception {
        Optional<UsuarioEntity> usuarioEntity = repository.findByUsuario(loginDTO.getUsuario());

        if (!usuarioEntity.isPresent()) {
            throw new Exception("Usuário não localizado!");
        }

        if (!usuarioEntity.get().getSenha().equals(loginDTO.getSenha())) {
            throw new Exception("Senha incorreta!");
        }

        return usuarioEntity.get();

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

        usuarioEntity.setId(usuarioSalvo.getId());

        tokenEntity.setUsuario(usuarioEntity);
        tokenEntity.setToken(UUID.randomUUID().toString());
        TokenEntity tokenCriado = tokenService.create(tokenEntity);

        usuarioSalvo.setToken(tokenCriado);

        repository.save(usuarioSalvo);
        return this.consultarTodos();
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

}