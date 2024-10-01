package com.spring.spring.usuario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.dto.UsuarioDTO;
import com.spring.spring.usuario.entity.UsuarioEntity;
import com.spring.spring.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> consultarTodos() {
        List<UsuarioEntity> usuarios = service.consultarTodos();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuario) {
        List<UsuarioEntity> usuarios = null;

        try {
            usuarios = service.create(usuario);
            return ResponseEntity.ok().body(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error:" + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UsuarioDTO usuario) {
        List<UsuarioEntity> usuarios = null;

        try {
            usuarios = service.update(usuario);
            return ResponseEntity.ok().body(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error:" + e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<UsuarioEntity>> delete(@PathVariable long id) {
        List<UsuarioEntity> usuarios = service.delete(id);
        return ResponseEntity.ok().body(usuarios);
    }

}
