package com.api.code.controller;

import com.api.code.dominio.Paciente;
import com.api.code.dominio.PacienteRemovido;
import com.api.code.dominio.Usuario;
import com.api.code.repository.PacienteRemovidoRepository;
import com.api.code.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PacienteRemovidoRepository pacienteRemovidoRepository;

    PacienteRemovido pacienteRemovido;

    @GetMapping("list")
    @ResponseBody
    public List<Paciente> listar() {

        return pacienteRepository.findAll();

    }

    @PostMapping("inclusao")
    public ResponseEntity<Paciente> inclusao(@Valid @RequestBody Paciente paciente) {

        pacienteRepository.save(paciente);

        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }

    @GetMapping("remosao")
    public ResponseEntity<Paciente> remosao(@QueryParam("id") Long id) {
        Optional<Paciente> optional = pacienteRepository.findById(id);
        if (optional.isPresent()) {
            pacienteRemovidoRepository.save(preenchendoRemovido(id));
            pacienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    private PacienteRemovido preenchendoRemovido(Long id) {
        pacienteRemovido = new PacienteRemovido();
        Paciente paciente= pacienteRepository.getById(id);
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
