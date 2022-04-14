package com.api.code.dominio;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String nomeProcedimento;

    @NotNull
    @Column
    private Long valor;

    @NotNull
    @Column
    private Long tempoGasto;
}
