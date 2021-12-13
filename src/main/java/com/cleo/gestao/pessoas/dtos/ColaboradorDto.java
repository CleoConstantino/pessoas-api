package com.cleo.gestao.pessoas.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorDto {

    private Long id;

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    private int idade;

    @CPF
    private String cpf;

    private LocalDate dataNascimento;

    private Long cargoId;

}
