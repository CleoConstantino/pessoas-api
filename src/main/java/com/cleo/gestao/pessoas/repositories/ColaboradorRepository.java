package com.cleo.gestao.pessoas.repositories;

import com.cleo.gestao.pessoas.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
