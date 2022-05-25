package com.api.code.repository;

import com.api.code.dominio.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}
