package com.api.code.controller;

import com.api.code.dominio.Paciente;
import com.api.code.dominio.Responsavel;
import com.api.code.dto.NovoPacienteDTO;
import com.api.code.repository.PacienteRemovidoRepository;
import com.api.code.repository.PacienteRepository;
import com.api.code.repository.ResponsavelRepository;
import com.api.code.service.PacienteService;
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
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ResponsavelRepository reponsavelRepository;

    @Autowired
    PacienteRemovidoRepository pacienteRemovidoRepository;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("listagem")
    @ResponseBody
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @PostMapping("incluir")
    public ResponseEntity<Paciente> incluir(@Valid @RequestBody NovoPacienteDTO novoPacienteDTO) {
        Responsavel responsavel = new Responsavel();
        if(!novoPacienteDTO.isMaiorIdade()){
            responsavel = reponsavelRepository.save(novoPacienteDTO.getNovoResponsavelDTO().toResponsavel());
        }
        Paciente paciente = pacienteRepository.save(novoPacienteDTO.toPaciente(responsavel.getId()));
        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }

    @GetMapping("deletar")
    public ResponseEntity<Paciente> deletar(@QueryParam("id") Long id) {
        Optional<Paciente> optional = pacienteRepository.findById(id);
        if (optional.isPresent()) {
            pacienteRemovidoRepository.save(pacienteService.preenchendoRemovido(id));
            pacienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("buscarPorId")
    public ResponseEntity<Paciente> BuscarPorId(@QueryParam("id") Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PutMapping("editar/{id}")
    @ResponseBody
    public Paciente editar(@PathVariable Long id, @RequestBody @Valid Paciente paciente) {

        Paciente pacienteAtualizado = pacienteService.atualizar(id, paciente);

        return pacienteRepository.save(pacienteAtualizado);
    }

    @GetMapping("consultarPorCPF")
    @ResponseBody
    public Paciente buscarPacienteCpf(@Valid @QueryParam("cpf") String cpf) {
        return pacienteRepository.findPacienteByCpf(cpf);

    }
}

