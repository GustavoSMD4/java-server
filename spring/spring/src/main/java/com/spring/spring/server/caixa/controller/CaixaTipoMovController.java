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

import com.spring.spring.dto.caixa.CaixaTipoMovDTO;
import com.spring.spring.server.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.server.caixa.service.CaixaTipoMovService;

@RestController
@RequestMapping("/caixa/tipo")
@CrossOrigin
public class CaixaTipoMovController {
    private CaixaTipoMovService caixaTipoMovService;

    public CaixaTipoMovController(CaixaTipoMovService caixaTipoMovService) {
        this.caixaTipoMovService = caixaTipoMovService;
    }

    @GetMapping
    public ResponseEntity<List<CaixaTipoMovEntity>> consultarTodos()
            throws Exception {
        return ResponseEntity.ok().body(caixaTipoMovService.consultarTodos());
    }

    @PostMapping("/create")
    public ResponseEntity<List<CaixaTipoMovEntity>> create(@RequestBody CaixaTipoMovDTO caixaTipoMovDTO)
            throws Exception {
        List<CaixaTipoMovEntity> tipos = caixaTipoMovService.create(caixaTipoMovDTO);
        return ResponseEntity.ok().body(tipos);
    }

    @PostMapping("/update")
    public ResponseEntity<List<CaixaTipoMovEntity>> update(@RequestBody CaixaTipoMovDTO caixaTipoMovDTO)
            throws Exception {
        List<CaixaTipoMovEntity> tipos = caixaTipoMovService.update(caixaTipoMovDTO);
        return ResponseEntity.ok().body(tipos);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<CaixaTipoMovEntity>> delete(@PathVariable long id) throws Exception {
        List<CaixaTipoMovEntity> tipos = caixaTipoMovService.delete(id);
        return ResponseEntity.ok().body(tipos);
    }

}
