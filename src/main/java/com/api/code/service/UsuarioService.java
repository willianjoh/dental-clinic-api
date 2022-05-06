package com.api.code.service;

import com.api.code.dominio.Usuario;
import com.api.code.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario atualizar(Long id, Usuario usuario) {

        Usuario usuarioEditado = usuarioRepository.getById(id);

        usuarioEditado.setCpf(usuario.getCpf());
        usuarioEditado.setEmail(usuario.getEmail());
        usuarioEditado.setCelular(usuario.getCelular());
        usuarioEditado.setDataNascimento(usuario.getDataNascimento());
        usuarioEditado.setUserName(usuario.getUserName());
        usuarioEditado.setSenha(usuario.getSenha());
        return usuarioEditado;
    }
}
