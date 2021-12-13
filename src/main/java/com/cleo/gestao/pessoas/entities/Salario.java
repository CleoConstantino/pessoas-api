package com.cleo.gestao.pessoas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "salarios")
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salario_sequence")
    @SequenceGenerator(name = "salario_sequence", sequenceName = "sal_seq")
    private Long id;

    private int grade;

    private BigDecimal salario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

}
