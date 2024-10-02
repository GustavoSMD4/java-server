package com.spring.spring.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class ControllerAbstract<Entidade, ID> {

    private ServiceAbstract<Entidade, ID> service;

    @GetMapping
    public ResponseEntity<List<Entidade>> consultarTodos() {
        return ResponseEntity.ok().body(service.consultarTodos());
    }

    @PostMapping("/create")
    public ResponseEntity<List<Entidade>> create(@RequestBody Entidade entidade) {
        service.salvar(entidade);
        return ResponseEntity.ok().body(service.consultarTodos());
    }
}
