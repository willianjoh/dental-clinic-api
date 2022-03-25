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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String nome;

    @NotNull
    @Column
    private String sobrenome;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private String senha;

    @NotNull
    @Column
    private String celular;

    @NotNull
    @Column
    private Date dataNascimento;

    @NotNull
    @Column
    private String cpf;
}
