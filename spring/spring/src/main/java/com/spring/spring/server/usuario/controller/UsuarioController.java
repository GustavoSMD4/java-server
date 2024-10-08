package com.spring.spring.server.usuario.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.dto.LoginDTO;
import com.spring.spring.dto.UsuarioDTO;
import com.spring.spring.server.usuario.entity.UsuarioEntity;
import com.spring.spring.server.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> consultarTodos() throws Exception {
        List<UsuarioEntity> usuarios = service.consultarTodos();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> consultarPorId(@PathVariable long id) throws Exception {
        return ResponseEntity.ok().body(service.consultarPorId(id));
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioEntity> login(@RequestBody LoginDTO loginDTO) throws Exception {
        UsuarioEntity usuarioLogado = service.login(loginDTO);
        return ResponseEntity.ok().body(usuarioLogado);
    }

    @PostMapping("/create")
    public ResponseEntity<List<UsuarioEntity>> create(@RequestBody UsuarioDTO usuario) throws Exception {
        List<UsuarioEntity> usuarios = null;
        usuarios = service.create(usuario);
        return ResponseEntity.ok().body(usuarios);

    }

    @PostMapping("/update")
    public ResponseEntity<List<UsuarioEntity>> update(@RequestBody UsuarioDTO usuario) throws Exception {
        List<UsuarioEntity> usuarios = service.update(usuario);
        return ResponseEntity.ok().body(usuarios);

    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<UsuarioEntity>> delete(@PathVariable long id) throws Exception {
        List<UsuarioEntity> usuarios = service.delete(id);
        return ResponseEntity.ok().body(usuarios);
    }

}
