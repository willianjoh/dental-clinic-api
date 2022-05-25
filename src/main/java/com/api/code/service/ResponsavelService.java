package com.api.code.service;

import com.api.code.dominio.Responsavel;
import com.api.code.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {

    @Autowired
    ResponsavelRepository responsavelRepository;

    public Responsavel atualizar(Long id, Responsavel responsavel) {

        Responsavel responsavelAtualizado = responsavelRepository.getById(id);
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
