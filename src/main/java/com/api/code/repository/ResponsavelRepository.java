package com.api.code.repository;

import com.api.code.dominio.PacienteRemovido;
import com.api.code.dominio.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}
