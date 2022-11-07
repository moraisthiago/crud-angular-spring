package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.UsuarioDTO;
import com.example.model.Foto;
import com.example.model.Usuario;
import com.example.repository.FotoRepository;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FotoRepository fotoRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());

        return usuarioRepository.save(usuario);

    }

    // public ResponseEntity<Usuario> save(UsuarioDTO usuarioDTO) {

    // Optional<Foto> imagemOptional =
    // fotoRepository.findById(usuarioDTO.getImagem().getId());

    // if (imagemOptional.isPresent()) {

    // Foto imagem = imagemOptional.get();
    // usuarioDTO.setImagem(imagem);

    // Usuario usuario = new Usuario();

    // usuario.setNome(usuarioDTO.getNome());
    // usuario.setSobrenome(usuarioDTO.getSobrenome());
    // usuario.setEmail(usuarioDTO.getEmail());
    // usuario.setSenha(usuarioDTO.getSenha());

    // usuarioRepository.save(usuario);

    // return new ResponseEntity<>(usuario, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

    // }

}
