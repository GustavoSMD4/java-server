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

import com.spring.spring.caixa.entity.CaixaMovEntity;
import com.spring.spring.caixa.service.CaixaMovService;
import com.spring.spring.dto.caixa.CaixaMovDTO;
import com.spring.spring.token.service.TokenService;

@RestController
@RequestMapping("/caixa/movimentacao")
@CrossOrigin
public class CaixaMovController {
    private CaixaMovService caixaMovService;
    private TokenService tokenService;

    public CaixaMovController(CaixaMovService caixaMovService, TokenService tokenService) {
        this.caixaMovService = caixaMovService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<List<CaixaMovEntity>> consultarTodos(@RequestHeader("Authorization") String auth)
            throws Exception {
        tokenService.validarToken(auth);
        return ResponseEntity.ok().body(caixaMovService.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaixaMovEntity> consultarPorId(@RequestHeader("Authorization") String auth, @PathVariable long id)
            throws Exception {
        tokenService.validarToken(auth);
        return ResponseEntity.ok().body(caixaMovService.consultarPorId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<List<CaixaMovEntity>> create(@RequestHeader("Authorization") String auth,
            @RequestBody CaixaMovDTO caixaMovDTO)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaMovEntity> movimentacoes = caixaMovService.create(caixaMovDTO);
        return ResponseEntity.ok().body(movimentacoes);
    }

    @PostMapping("/update")
    public ResponseEntity<List<CaixaMovEntity>> update(@RequestHeader("Authorization") String auth,
            @RequestBody CaixaMovDTO caixaMovDTO)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaMovEntity> movimentacaoes = caixaMovService.update(caixaMovDTO);
        return ResponseEntity.ok().body(movimentacaoes);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<CaixaMovEntity>> delete(@RequestHeader("Authorization") String auth, @PathVariable long id)
            throws Exception {
        tokenService.validarToken(auth);
        List<CaixaMovEntity> caixas = caixaMovService.delete(id);
        return ResponseEntity.ok().body(caixas);
    }

}
