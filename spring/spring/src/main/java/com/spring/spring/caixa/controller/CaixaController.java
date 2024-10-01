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

import com.spring.spring.caixa.entity.CaixaEntity;
import com.spring.spring.caixa.service.CaixaService;
import com.spring.spring.token.service.TokenService;

@RestController
@RequestMapping("/caixa")
@CrossOrigin
public class CaixaController {
    private CaixaService caixaService;
    private TokenService tokenService;

    public CaixaController(CaixaService caixaService, TokenService tokenService) {
        this.caixaService = caixaService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<List<CaixaEntity>> consultarTodos(@RequestHeader("Authorization") String auth)
            throws Exception {
        tokenService.validarToken(auth);
        return ResponseEntity.ok().body(caixaService.consultarTodos());
    }

    @PostMapping("/create")
    public ResponseEntity<List<CaixaEntity>> create(@RequestHeader("Authorization") String auth,
            @RequestBody CaixaEntity caixaEntity)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaEntity> caixas = caixaService.create(caixaEntity);
        return ResponseEntity.ok().body(caixas);
    }

    @PostMapping("/update")
    public ResponseEntity<List<CaixaEntity>> update(@RequestHeader("Authorization") String auth,
            @RequestBody CaixaEntity caixaEntity)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaEntity> caixas = caixaService.update(caixaEntity);
        return ResponseEntity.ok().body(caixas);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<CaixaEntity>> delete(@RequestHeader("Authorization") String auth, @PathVariable long id)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaEntity> caixas = caixaService.delete(id);
        return ResponseEntity.ok().body(caixas);
    }

}
