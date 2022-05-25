package com.api.code.controller;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Usuario;
import com.api.code.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    Atendimento atendimento;

    @PostMapping("inclusao")
    public ResponseEntity<Atendimento> inclusao(@Valid @RequestBody Atendimento atendimento) {

        atendimentoRepository.save(atendimento);

        return new ResponseEntity<>(atendimento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Atendimento> optional = atendimentoRepository.findById(id);
        if (optional.isPresent()) {
            atendimentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("list")
    @ResponseBody
    public List<Atendimento> listar() {

        return atendimentoRepository.findAll();

    }

    @GetMapping("listIdDentista/{id}")
    @ResponseBody
    public List<Atendimento> listaridDentista(@PathVariable Long id ) {

        return atendimentoRepository.findByIdDentista(id);

    }
}
