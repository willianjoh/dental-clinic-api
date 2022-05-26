package com.api.code.controller;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Orcamento;
import com.api.code.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@Controller
@RequestMapping("/api/orcamento")
public class OrcamentoController {

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @PostMapping("incluir")
    public ResponseEntity<Orcamento> incluir(@Valid @RequestBody Orcamento orcamento) {
        Orcamento orcamento1 = orcamentoRepository.save(orcamento);
        return new ResponseEntity<>(orcamento1, HttpStatus.CREATED);
    }

    @GetMapping("deletar")
    public ResponseEntity<Orcamento> deletar(@QueryParam("id") Long id) {
        Optional<Orcamento> optional = orcamentoRepository.findById(id);
        if (optional.isPresent()) {
            orcamentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("editar/{id}")
    @ResponseBody
    public Orcamento editar(@PathVariable Long id, @RequestBody @Valid Orcamento orcamento) {
       // Orcamento orcamento = atendimentoService.atualizar(id, orcamento);
        //return orcamentoRepository.save(atendimentoAtualizado);
        return null;
    }

    @GetMapping("buscarPorId")
    public ResponseEntity<Orcamento> BuscarPorId(@QueryParam("id") Long id) {
        Orcamento orcamento = orcamentoRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(orcamento, HttpStatus.OK);
    }

}
