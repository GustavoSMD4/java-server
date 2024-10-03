package com.spring.spring.server.caixa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.dto.caixa.CaixaMovDTO;
import com.spring.spring.server.caixa.entity.CaixaMovEntity;
import com.spring.spring.server.caixa.service.CaixaMovService;

@RestController
@RequestMapping("/caixa/movimentacao")
@CrossOrigin
public class CaixaMovController {
    private CaixaMovService caixaMovService;

    public CaixaMovController(CaixaMovService caixaMovService) {
        this.caixaMovService = caixaMovService;
    }

    @GetMapping
    public ResponseEntity<List<CaixaMovEntity>> consultarTodos() throws Exception {
        return ResponseEntity.ok().body(caixaMovService.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaixaMovEntity> consultarPorId(@PathVariable long id) throws Exception {
        return ResponseEntity.ok().body(caixaMovService.consultarPorId(id));
    }

    @GetMapping("/caixa/{idCaixa}")
    public ResponseEntity<List<CaixaMovEntity>> consultarPorIdCaixa(@PathVariable long idCaixa) throws Exception {
        return ResponseEntity.ok().body(caixaMovService.consultarPorIdCaixa(idCaixa));
    }

    @PostMapping("/create")
    public ResponseEntity<List<CaixaMovEntity>> create(@RequestBody CaixaMovDTO caixaMovDTO) throws Exception {
        List<CaixaMovEntity> movimentacoes = caixaMovService.create(caixaMovDTO);
        return ResponseEntity.ok().body(movimentacoes);
    }

    @PostMapping("/update")
    public ResponseEntity<List<CaixaMovEntity>> update(@RequestBody CaixaMovDTO caixaMovDTO) throws Exception {
        List<CaixaMovEntity> movimentacaoes = caixaMovService.update(caixaMovDTO);
        return ResponseEntity.ok().body(movimentacaoes);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<CaixaMovEntity>> delete(@PathVariable long id) throws Exception {
        List<CaixaMovEntity> caixas = caixaMovService.delete(id);
        return ResponseEntity.ok().body(caixas);
    }

}
