package com.example.dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Foto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    // private Foto imagem;
}
