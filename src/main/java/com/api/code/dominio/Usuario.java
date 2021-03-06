package com.api.code.dominio;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @Column(unique = true)
    @NotEmpty(message = "Campo Obrigatório")
    private String userName;

    @Column
    private String email;

    @NotNull
    @Column
    @NotEmpty(message = "Campo Obrigatório")
    private String senha;

    @Column
    private String celular;

    @Column
    private Date dataNascimento;

    @Column
    private String cpf;
}
