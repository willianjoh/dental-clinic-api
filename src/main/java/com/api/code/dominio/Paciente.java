package com.api.code.dominio;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String nomeCompleto;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private String cpf;

    @Column
    private String rg;

    @NotNull
    @Column
    private Date dataNascimento;

    @NotNull
    @Column
    private String celular;

    @NotNull
    @Column
    private String genero;

    @NotNull
    @Column
    private String profissao;

    @Column
    private String telefoneFixo;

    @Column
    private Long maiorIdade;

    @OneToOne
    @JoinColumn(name = "id_Responsavel")
    private Responsavel responsavel;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_dentista")
    private Usuario dentistaResponsavel;

    @Column
    private String informacoesAdicionais;

}
