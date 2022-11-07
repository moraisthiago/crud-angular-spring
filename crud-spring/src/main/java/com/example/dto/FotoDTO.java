package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FotoDTO {

    private String nome;
    private String tipo;
    private byte[] imagem;
}
