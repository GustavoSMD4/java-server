package com.spring.spring.server.role.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.server.role.entity.RoleEntity;
import com.spring.spring.server.role.service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {
    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RoleEntity>> consultarTodos() throws Exception {
        List<RoleEntity> roles = service.consultarTodos();
        return ResponseEntity.ok().body(roles);
    }

    @PostMapping("/create")
    public ResponseEntity<List<RoleEntity>> create(@RequestBody RoleEntity roleEntity) throws Exception {
        List<RoleEntity> roles = service.create(roleEntity);
        return ResponseEntity.ok().body(roles);
    }

    @PostMapping("/update")
    public ResponseEntity<List<RoleEntity>> update(@RequestBody RoleEntity roleEntity) throws Exception {
        List<RoleEntity> roles = service.update(roleEntity);
        return ResponseEntity.ok().body(roles);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<RoleEntity>> delete(@PathVariable long id) throws Exception {
        List<RoleEntity> roles = service.delete(id);
        return ResponseEntity.ok().body(roles);
    }

}
