package com.api.code.repository;

import com.api.code.dominio.Atendimento;
import com.api.code.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository  extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findByIdDentista(Long id);
}
