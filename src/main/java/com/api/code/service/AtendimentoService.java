package com.api.code.service;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Paciente;
import com.api.code.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    public Atendimento atualizar(Long id, Atendimento atendimento) {

        Atendimento atendimentoSalvar = atendimentoRepository.getById(id);
        atendimentoSalvar.setDataAtendimento(atendimento.getDataAtendimento());
        atendimentoSalvar.setHorario(atendimento.getHorario());
        atendimentoSalvar.setCpfPaciente(atendimento.getCpfPaciente());
        atendimentoSalvar.setNomePaciente(atendimento.getNomePaciente());
        atendimentoSalvar.setLocal(atendimento.getLocal());
        atendimentoSalvar.setObservacao(atendimento.getObservacao());
        return atendimentoSalvar;

    }
}
