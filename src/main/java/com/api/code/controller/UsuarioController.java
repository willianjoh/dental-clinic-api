package com.api.code.controller;

import com.api.code.dominio.Usuario;
import com.api.code.exception.UsuarioCadastradoException;
import com.api.code.repository.UsuarioRepository;
import com.api.code.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("list")
    @ResponseBody
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping("incluir")
    public ResponseEntity<Usuario> incluir(@Valid @RequestBody Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
        } catch (UsuarioCadastradoException usuarioCadastradoException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, usuarioCadastradoException.getMessage());
        }
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @ResponseBody
    public Usuario atualizar(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        Usuario atualizado = usuarioService.atualizar(id, usuario);
        return usuarioRepository.save(atualizado);
    }

}
