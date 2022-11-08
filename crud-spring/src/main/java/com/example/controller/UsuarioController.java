package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UsuarioDTO;
import com.example.model.Usuario;
import com.example.service.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable UUID id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(id, usuarioDTO);
    }
}
