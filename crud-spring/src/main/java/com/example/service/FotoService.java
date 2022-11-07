package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.FotoDTO;
import com.example.model.Foto;
import com.example.repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public List<Foto> findAll() {
        return fotoRepository.findAll();
    }

    public Foto save(FotoDTO fotoDTO) {
        Foto foto = new Foto();

        foto.setNome(fotoDTO.getNome());
        foto.setTipo(fotoDTO.getTipo());
        foto.setImagem(fotoDTO.getImagem());

        return fotoRepository.save(foto);
    }
}
