package com.api.code.dto;

import com.api.code.dominio.Endereco;
import com.api.code.dominio.Responsavel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class NovoResponsavelDTO {

    private String nomeCompleto;
    private String email;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String celular;
    private String genero;
    private String profissao;
    private String telefoneFixo;
    private Endereco endereco;

    public Responsavel toResponsavel(){
        Responsavel responsavel = new Responsavel();
        responsavel.setNomeCompleto(nomeCompleto);
        responsavel.setEmail(email);
        responsavel.setCpf(cpf);
        responsavel.setRg(rg);
        responsavel.setDataNascimento(dataNascimento);
        responsavel.setCelular(celular);
        responsavel.setGenero(genero);
        responsavel.setProfissao(profissao);
        responsavel.setTelefoneFixo(telefoneFixo);
        responsavel.setEndereco(endereco);
        return responsavel;
    }
}
