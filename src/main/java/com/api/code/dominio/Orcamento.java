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
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private Long valorTotal;

    @OneToOne
    @JoinColumn(name = "id_Pessoa")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_dentista")
    private Usuario dentistaResponsavel;

    @NotNull
    @Column
    private Date dataValidadeOrcameto;

    @NotNull
    @Column
    private Date dataOrcamento;

    @OneToMany
    @JoinColumn(name = "id_procedimento")
    private List<Procedimento> procedimentosList;

    @OneToMany
    @JoinColumn(name = "id_exame")
    private List<Exame> examesList;
}
