package com.api.code.controller;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Paciente;
import com.api.code.repository.AtendimentoRepository;
import com.api.code.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @Autowired
    AtendimentoService atendimentoService;


    @PostMapping("incluir")
    public ResponseEntity<Atendimento> incluir(@Valid @RequestBody Atendimento atendimento) {

        atendimentoRepository.save(atendimento);
        return new ResponseEntity<>(atendimento, HttpStatus.CREATED);
    }

    @GetMapping("listagem")
    @ResponseBody
    public List<Atendimento> listar() {
        return atendimentoRepository.findAll();

    }

    @GetMapping("deletar")
    public ResponseEntity<Atendimento> deletar(@QueryParam("id") Long id) {
        Optional<Atendimento> optional = atendimentoRepository.findById(id);
        if (optional.isPresent()) {
            atendimentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("editar/{id}")
    @ResponseBody
    public Atendimento editar(@PathVariable Long id, @RequestBody @Valid Atendimento atendimento) {
        Atendimento atendimentoAtualizado = atendimentoService.atualizar(id, atendimento);
        return atendimentoRepository.save(atendimentoAtualizado);
    }

    @GetMapping("buscarPorId")
    public ResponseEntity<Atendimento> BuscarPorId(@QueryParam("id") Long id) {
        Atendimento atendimento = atendimentoRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(atendimento, HttpStatus.OK);
    }

    @GetMapping("listIdDentista/{id}")
    @ResponseBody
    public List<Atendimento> listaridDentista(@PathVariable Long id ) {

        return atendimentoRepository.findByIdDentista(id);

    }
}
