package com.api.code.repository;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}
