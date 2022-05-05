package com.api.code.repository;

import com.api.code.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

//    @Override
//    @Query(value = "SELECT p FROM Paciente p left join PacienteRemovido pr")
//    List<Paciente> findAll();
}
