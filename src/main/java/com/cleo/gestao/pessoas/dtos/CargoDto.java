package com.cleo.gestao.pessoas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class CargoDto {

    private Long id;

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    private String descricao;

    private List<Long> colaboradores;

    private List<Long> salarios;

}
