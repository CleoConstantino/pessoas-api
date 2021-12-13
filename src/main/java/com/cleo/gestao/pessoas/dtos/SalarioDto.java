package com.cleo.gestao.pessoas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalarioDto {

    private Long id;

    private int grade;

    private BigDecimal salario;

    private Long cargoId;

}
