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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String cep;

    @NotNull
    @Column
    private Long numero;

    @NotNull
    @Column
    private String logradouro;

    @NotNull
    @Column
    private String bairro;

    @Column
    private String complemento;

    @NotNull
    @Column
    private String uf;

    @NotNull
    @Column
    private String cidade;

}
