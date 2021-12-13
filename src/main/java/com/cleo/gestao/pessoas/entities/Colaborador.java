package com.cleo.gestao.pessoas.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colaborador_sequence")
    @SequenceGenerator(name = "colaborador_sequence", sequenceName = "col_seq")
    private Long id;

    private String nome;

    private int idade;

    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;


}
