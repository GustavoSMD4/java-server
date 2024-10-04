package com.spring.spring.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class ControllerAbstract<Entidade, ID, Repository extends JpaRepository<Entidade, ID>, Service extends ServiceAbstract<Entidade, ID, Repository>> {

    @Autowired
    protected Service service;

    @GetMapping
    public ResponseEntity<List<Entidade>> consultaTodos() {
        return ResponseEntity.ok().body(service.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entidade> consultarPorId(@PathVariable ID id) throws Exception {
        return ResponseEntity.ok().body(service.consultarPorId(id));
    }

}
