package com.spring.spring.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.spring.spring.token.service.TokenService;

public abstract class ControllerAbstract<Entidade, ID> {

    protected ServiceAbstract<Entidade, ID> service;
    protected TokenService tokenService;

    public ControllerAbstract(ServiceAbstract<Entidade, ID> service, TokenService tokenService) {
        this.service = service;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<List<Entidade>> consultarTodos(@RequestHeader("Authorization") String auth) throws Exception {
        tokenService.validarToken(auth);
        return ResponseEntity.ok().body(service.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entidade> consultarTodos(@RequestHeader("Authorization") String auth, @PathVariable ID id)
            throws Exception {
        tokenService.validarToken(auth);
        Entidade entidade = service.consultarPorId(id);
        return ResponseEntity.ok().body(entidade);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Entidade>> create(@RequestHeader("Authorization") String auth,
            @RequestBody Object req) throws Exception {
        
        @SuppressWarnings("unchecked")
        Entidade entidade = (Entidade) req;
        tokenService.validarToken(auth);
        service.salvar(entidade);
        return ResponseEntity.ok().body(service.consultarTodos());
    }

    @PostMapping("/update")
    public ResponseEntity<List<Entidade>> update(@RequestHeader("Authorization") String auth,
            @RequestBody Entidade entidade) throws Exception {

        tokenService.validarToken(auth);
        service.salvar(entidade);
        return ResponseEntity.ok().body(service.consultarTodos());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<Entidade>> delete(@RequestHeader("Authorization") String auth,
            @RequestBody ID id) throws Exception {

        tokenService.validarToken(auth);
        service.delete(id);
        return ResponseEntity.ok().body(service.consultarTodos());
    }
}
