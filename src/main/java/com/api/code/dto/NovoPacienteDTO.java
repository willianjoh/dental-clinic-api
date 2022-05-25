package com.api.code.dto;

import com.api.code.dominio.Endereco;
import com.api.code.dominio.Paciente;
import com.api.code.dominio.Responsavel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class NovoPacienteDTO {

    private String nomeCompleto;
    private String email;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String celular;
    private String genero;
    private String profissao;
    private String telefoneFixo;
    private NovoResponsavelDTO novoResponsavelDTO;
    private Endereco endereco;
    private boolean maiorIdade;
    private Long idDentistaResponsavel;
    private String informacoesAdicionais;

    public Paciente toPaciente(Long id) {
        Paciente paciente = new Paciente();
        paciente.setNomeCompleto(nomeCompleto);
        paciente.setEmail(email);
        paciente.setCpf(cpf);
        paciente.setRg(rg);
        paciente.setDataNascimento(dataNascimento);
        paciente.setCelular(celular);
        paciente.setGenero(celular);
        paciente.setProfissao(profissao);
        paciente.setTelefoneFixo(telefoneFixo);
        paciente.setEndereco(endereco);
        paciente.setMaiorIdade(maiorIdade);
        paciente.setIdResponsavel(id);
        paciente.setIdDentistaResponsavel(idDentistaResponsavel);
        paciente.setInformacoesAdicionais(informacoesAdicionais);
        return paciente;
    }


}
