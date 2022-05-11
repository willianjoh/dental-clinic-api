package com.api.code.service;

import com.api.code.dominio.Usuario;
import com.api.code.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService implements UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario
                = usuarioRepository.findByUserName(s).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
        return User
                .builder()
                .username(usuario.getUserName())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }
}
