package com.api.code.repository;


import com.api.code.dominio.PacienteRemovido;
import com.api.code.dominio.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRemovidoRepository extends JpaRepository<PacienteRemovido, Long> {

}
