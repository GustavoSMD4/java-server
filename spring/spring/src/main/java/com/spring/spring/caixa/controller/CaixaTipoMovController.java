package com.spring.spring.caixa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.caixa.service.CaixaTipoMovService;
import com.spring.spring.token.service.TokenService;


@RestController
@RequestMapping("/caixa/tipo")
@CrossOrigin
public class CaixaTipoMovController {

    private CaixaTipoMovService caixaTipoMovService;
    private TokenService tokenService;

    public CaixaTipoMovController(CaixaTipoMovService caixaTipoMovService, TokenService tokenService) {
        this.caixaTipoMovService = caixaTipoMovService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<List<CaixaTipoMovEntity>> consultarTodos(@RequestHeader("Authorization") String auth)
            throws Exception {
        tokenService.validarToken(auth);
        return ResponseEntity.ok().body(caixaTipoMovService.consultarTodos());
    }

    @PostMapping("/create")
    public ResponseEntity<List<CaixaTipoMovEntity>> create(@RequestHeader("Authorization") String auth,
            @RequestBody CaixaTipoMovEntity caixaTipoMovEntity)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaTipoMovEntity> tipos = caixaTipoMovService.salvar(caixaTipoMovEntity);
        return ResponseEntity.ok().body(tipos);
    }

    @PostMapping("/update")
    public ResponseEntity<List<CaixaTipoMovEntity>> update(@RequestHeader("Authorization") String auth,
            @RequestBody CaixaTipoMovEntity caixaTipoMovEntity)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaTipoMovEntity> tipos = caixaTipoMovService.salvar(caixaTipoMovEntity);
        return ResponseEntity.ok().body(tipos);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<CaixaTipoMovEntity>> delete(@RequestHeader("Authorization") String auth, @PathVariable long id)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaTipoMovEntity> tipos = caixaTipoMovService.delete(id);
        return ResponseEntity.ok().body(tipos);
    }

   
}
