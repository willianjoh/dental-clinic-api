package com.api.code.service;

import com.api.code.dominio.Paciente;
import com.api.code.dominio.Paciente;
import com.api.code.dominio.PacienteRemovido;
import com.api.code.dominio.Usuario;
import com.api.code.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente atualizar(Long id, Paciente paciente) {

        Paciente pacienteAtualizado = pacienteRepository.getById(id);

        pacienteAtualizado.setCelular(paciente.getCelular());
        pacienteAtualizado.setNomeCompleto(paciente.getNomeCompleto());
        pacienteAtualizado.setRg(paciente.getRg());
        pacienteAtualizado.setGenero(paciente.getGenero());
        pacienteAtualizado.setProfissao(paciente.getProfissao());
        pacienteAtualizado.setTelefoneFixo(paciente.getTelefoneFixo());
        pacienteAtualizado.setMaiorIdade(paciente.getMaiorIdade());
        pacienteAtualizado.setIdResponsavel(paciente.getIdResponsavel());
        pacienteAtualizado.setIdDentistaResponsavel(paciente.getIdDentistaResponsavel());
        pacienteAtualizado.setInformacoesAdicionais(paciente.getInformacoesAdicionais());
        pacienteAtualizado.setCpf(paciente.getCpf());
        pacienteAtualizado.setEmail(paciente.getEmail());
        pacienteAtualizado.setDataNascimento(paciente.getDataNascimento());
        pacienteAtualizado.setEndereco(paciente.getEndereco());
        return pacienteAtualizado;

    }

    public PacienteRemovido preenchendoRemovido(Long id) {
        PacienteRemovido pacienteRemovido = new PacienteRemovido();
        Paciente paciente = pacienteRepository.getById(id);
        Date dataAtual = new Date();
        pacienteRemovido.setCelular(paciente.getCelular());
        pacienteRemovido.setNomeCompleto(paciente.getNomeCompleto());
        pacienteRemovido.setRg(paciente.getRg());
        pacienteRemovido.setGenero(paciente.getGenero());
        pacienteRemovido.setProfissao(paciente.getProfissao());
        pacienteRemovido.setTelefoneFixo(paciente.getTelefoneFixo());
        pacienteRemovido.setMaiorIdade(paciente.getMaiorIdade());
        pacienteRemovido.setIdResponsavel(paciente.getIdResponsavel());
        pacienteRemovido.setIdDentistaResponsavel(paciente.getIdDentistaResponsavel());
        pacienteRemovido.setInformacoesAdicionais(paciente.getInformacoesAdicionais());
        pacienteRemovido.setCpf(paciente.getCpf());
        pacienteRemovido.setEmail(paciente.getEmail());
        pacienteRemovido.setDataNascimento(paciente.getDataNascimento());
        pacienteRemovido.setEndereco(paciente.getEndereco());
        pacienteRemovido.setDataRemosão(dataAtual);
        return pacienteRemovido;
    }
}
