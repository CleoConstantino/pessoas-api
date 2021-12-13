package com.cleo.gestao.pessoas.repositories;

import com.cleo.gestao.pessoas.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
