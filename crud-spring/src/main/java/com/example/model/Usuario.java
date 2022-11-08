package com.example.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 150)
    @NotNull(message = "O campo de nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo de sobrenome não pode ser vazio!")
    private String sobrenome;

    @Email(message = "Insira um e-mail válido!")
    private String email;

    @NotNull(message = "O campo de senha não pode ser vazio!")
    @Size(min = 4, max = 8, message = "A senha deve conter de 4 a 8 caracteres!")
    private String senha;

    // @OneToOne
    // @JoinColumn(name = "id")
    // private Foto imagem;
}
