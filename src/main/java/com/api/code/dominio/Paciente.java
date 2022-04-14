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

    @OneToOne
    @JoinColumn(name = "id_Pessoa")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "id_Responsavel")
    private Responsavel responsavel;

    @OneToOne
    @JoinColumn(name = "id_dentista")
    private Usuario dentistaResponsavel;

    @Column
    private String informacoesAdicionais;

}
