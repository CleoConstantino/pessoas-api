package com.cleo.gestao.pessoas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargo_sequence")
    @SequenceGenerator(name = "cargo_sequence", sequenceName = "car_seq")
    private Long id;

    private String nome;

    private String descricao;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "cargo_id")
    private List<Colaborador> colaboradores;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "cargo_id")
    private List<Salario> salarios;

}
