package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.FotoDTO;
import com.example.model.Foto;
import com.example.service.FotoService;

@RestController
@RequestMapping("/foto")
@CrossOrigin("http://localhost:8081")
public class FotoCotroller {
    
    @Autowired
    private FotoService fotoService;

    @GetMapping
    public List<Foto> findAll() {
        return fotoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Foto save(@RequestParam("file") MultipartFile file) throws IOException {
        FotoDTO foto = new FotoDTO();

        foto.setNome(file.getOriginalFilename());
        foto.setTipo(file.getContentType());
        foto.setImagem(file.getBytes());
        
        return fotoService.save(foto);
    }
}
