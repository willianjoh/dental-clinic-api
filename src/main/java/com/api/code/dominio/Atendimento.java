package com.api.code.dominio;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String cpfPaciente;

    @Column
    @NotNull
    private Long idPaciente;

    @Column
    @NotNull
    private String nomePaciente;

    @Column
    @NotNull
    private Long idDentista;

    @Column
    private String observacao;

    @Column
    @NotNull
    private Date dataAtendimento;

    @Column
    @NotNull
    private LocalTime horario;

}
