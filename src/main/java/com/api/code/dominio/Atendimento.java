package com.api.code.dominio;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_Pessoa")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_dentista")
    private Usuario dentistaResponsavel;

    @NotNull
    @Column
    private Date dataAtendimento;

    @NotNull
    @Column
    private String horarioAtendimento;

    @OneToOne
    @JoinColumn(name = "id_orcamento")
    private Orcamento orcamento;
}
