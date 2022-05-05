package com.api.code.controller;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Paciente;
import com.api.code.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("atendimento")
public class AtendimentoContrroller {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    Atendimento atendimento;

    @PostMapping("inclusao")
    public ResponseEntity<Atendimento> inclusao(@Valid @RequestBody Atendimento atendimento) {

        atendimentoRepository.save(atendimento);

        return new ResponseEntity<>(atendimento, HttpStatus.CREATED);
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
