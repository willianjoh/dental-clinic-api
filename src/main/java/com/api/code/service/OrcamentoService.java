package com.api.code.service;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Orcamento;
import com.api.code.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {

    @Autowired
    OrcamentoRepository orcamentoRepository;

    public Orcamento atualizar(Long id, Orcamento orcamento) {

        Orcamento orcamento1 = orcamentoRepository.getById(id);
        orcamento1.setDataOrcamento(orcamento.getDataOrcamento());
        orcamento1.setValor(orcamento.getValor());
        orcamento1.setFormaPagamento(orcamento.getFormaPagamento());
        orcamento1.setObservacao(orcamento.getObservacao());
        orcamento1.setTipoProcedimento(orcamento.getTipoProcedimento());
        return orcamento1;

    }
}
