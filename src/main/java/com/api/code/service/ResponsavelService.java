package com.api.code.service;

import com.api.code.dominio.Responsavel;
import com.api.code.dominio.Usuario;
import com.api.code.repository.ReponsavelRepository;
import com.api.code.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {

    @Autowired
    ReponsavelRepository reponsavelRepository;

    public Responsavel atualizar(Long id, Responsavel responsavel) {

        Responsavel responsavelAtualizado = reponsavelRepository.getById(id);
        responsavelAtualizado.setNomeCompleto(responsavel.getNomeCompleto());
        responsavelAtualizado.setEmail(responsavel.getEmail());
        responsavelAtualizado.setRg(responsavel.getRg());
        responsavelAtualizado.setDataNascimento(responsavel.getDataNascimento());
        responsavelAtualizado.setCelular(responsavel.getCelular());
        responsavelAtualizado.setGenero(responsavel.getGenero());
        responsavelAtualizado.setProfissao(responsavel.getProfissao());
        responsavelAtualizado.setTelefoneFixo(responsavel.getTelefoneFixo());
        responsavelAtualizado.setEndereco(responsavel.getEndereco());
        responsavelAtualizado.setCpf(responsavel.getCpf());

        return responsavelAtualizado;
    }
}
