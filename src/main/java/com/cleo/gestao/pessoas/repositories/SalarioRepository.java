package com.cleo.gestao.pessoas.repositories;

import com.cleo.gestao.pessoas.entities.Salario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioRepository extends JpaRepository<Salario, Long> {
}
