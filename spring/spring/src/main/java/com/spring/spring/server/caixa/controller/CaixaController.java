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

import com.spring.spring.dto.caixa.CaixaDTO;
import com.spring.spring.server.caixa.entity.CaixaEntity;
import com.spring.spring.server.caixa.service.CaixaService;

@RestController
@RequestMapping("/caixa")
@CrossOrigin
public class CaixaController {
    private CaixaService caixaService;

    public CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;

    }

    @GetMapping
    public ResponseEntity<List<CaixaEntity>> consultarTodos() throws Exception {
        return ResponseEntity.ok().body(caixaService.consultarTodos());
    }

    @PostMapping("/create")
    public ResponseEntity<List<CaixaEntity>> create(@RequestBody CaixaDTO caixaDTO) throws Exception {
        List<CaixaEntity> caixas = caixaService.create(caixaDTO);
        return ResponseEntity.ok().body(caixas);
    }

    @PostMapping("/update")
    public ResponseEntity<List<CaixaEntity>> update(@RequestBody CaixaEntity caixaEntity) throws Exception {
        List<CaixaEntity> caixas = caixaService.salvar(caixaEntity);
        return ResponseEntity.ok().body(caixas);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<CaixaEntity>> delete(@PathVariable long id) throws Exception {
        List<CaixaEntity> caixas = caixaService.delete(id);
        return ResponseEntity.ok().body(caixas);
    }

}
