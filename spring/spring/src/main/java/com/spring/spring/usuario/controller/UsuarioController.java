package com.spring.spring.usuario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.dto.LoginDTO;
import com.spring.spring.dto.UsuarioDTO;
import com.spring.spring.token.service.TokenService;
import com.spring.spring.usuario.entity.UsuarioEntity;
import com.spring.spring.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
    private UsuarioService service;
    private TokenService tokenService;

    public UsuarioController(UsuarioService service, TokenService tokenService) {
        this.service = service;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> consultarTodos(@RequestHeader("Authorization") String auth) {
        try {
            tokenService.validarToken(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<UsuarioEntity> usuarios = service.consultarTodos();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try {
            UsuarioEntity usuarioLogado = service.login(loginDTO);
            return ResponseEntity.ok().body(usuarioLogado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestHeader("Authorization") String auth, @RequestBody UsuarioDTO usuario) {
        try {
            tokenService.validarToken(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<UsuarioEntity> usuarios = null;

        try {
            usuarios = service.create(usuario);
            return ResponseEntity.ok().body(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestHeader("Authorization") String auth, @RequestBody UsuarioDTO usuario) {
        try {
            tokenService.validarToken(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<UsuarioEntity> usuarios = null;

        try {
            usuarios = service.update(usuario);
            return ResponseEntity.ok().body(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<UsuarioEntity>> delete(@RequestHeader("Authorization") String auth,
            @PathVariable long id) {
        try {
            tokenService.validarToken(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<UsuarioEntity> usuarios = service.delete(id);
        return ResponseEntity.ok().body(usuarios);
    }

}
