package com.api.code.controller;

import com.api.code.dominio.Paciente;
import com.api.code.dominio.PacienteRemovido;
import com.api.code.dominio.Responsavel;
import com.api.code.dominio.Usuario;
import com.api.code.dto.NovoPacienteDTO;
import com.api.code.dto.NovoResponsavelDTO;
import com.api.code.repository.PacienteRemovidoRepository;
import com.api.code.repository.PacienteRepository;
import com.api.code.repository.ResponsavelRepository;
import com.api.code.service.PacienteService;
import com.api.code.service.ResponsavelService;
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
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ResponsavelRepository responsavelRepository;

    @Autowired
    PacienteRemovidoRepository pacienteRemovidoRepository;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("list")
    @ResponseBody
    public List<Paciente> listar() {

        return pacienteRepository.findAll();

    }

    @PostMapping("incluir")
    public ResponseEntity<Paciente> incluir(@Valid @RequestBody NovoPacienteDTO novoPacienteDTO) {
        Responsavel responsavel = new Responsavel();

        if (!novoPacienteDTO.isMaiorIdade()) {

            responsavel = responsavelRepository.save(novoPacienteDTO.getNovoResponsavelDTO().toResponsavel());
        }

        Paciente paciente = pacienteRepository.save(novoPacienteDTO.toPaciente(responsavel.getId()));

        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }

    @GetMapping("remosao")
    public ResponseEntity<Paciente> remosao(@QueryParam("id") Long id) {
        Optional<Paciente> optional = pacienteRepository.findById(id);
        if (optional.isPresent()) {
            PacienteRemovido pacienteRemover = pacienteService.preenchendoRemovido(id);
            if (pacienteRemover.getIdResponsavel() != null) {
                responsavelRepository.deleteById(pacienteRemover.getIdResponsavel());
            }
            pacienteRemovidoRepository.save(pacienteService.preenchendoRemovido(id));
            pacienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("atualizar/{id}")
    @ResponseBody
    public Paciente atualizar(@PathVariable Long id, @RequestBody @Valid Paciente paciente) {

        Paciente pacienteAtualizado = pacienteService.atualizar(id, paciente);

        return pacienteRepository.save(pacienteAtualizado);
    }

    @GetMapping("buscarPacienteCPF")
    @ResponseBody
    public Paciente buscarPacienteCpf(@Valid @QueryParam("cpfPaciente") String cpfPaciente) {
        return pacienteRepository.findPacienteByCpf(cpfPaciente);

    }
}

