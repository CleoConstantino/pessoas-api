package com.cleo.gestao.pessoas.controllers;

import com.cleo.gestao.pessoas.dtos.SalarioDto;
import com.cleo.gestao.pessoas.entities.Cargo;
import com.cleo.gestao.pessoas.entities.Salario;
import com.cleo.gestao.pessoas.repositories.CargoRepository;
import com.cleo.gestao.pessoas.repositories.SalarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/salarios")
public class SalarioController {

    private final SalarioRepository repository;
    private final CargoRepository cargoRepository;

    public SalarioController(SalarioRepository repository, CargoRepository cargoRepository) {
        this.repository = repository;
        this.cargoRepository = cargoRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Salario save(@Valid @RequestBody SalarioDto salarioDto) {
        Salario salario = new Salario();

        if (!Objects.isNull(salarioDto.getCargoId())) {
            Cargo cargo = cargoRepository.findById(salarioDto.getCargoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
            salario.setCargo(cargo);
        }

        salario.setSalario(salarioDto.getSalario());
        salario.setGrade(salarioDto.getGrade());

        return repository.save(salario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Salario findById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Salário não encontrado"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Salario update(@PathVariable("id") Long id, @Valid @RequestBody SalarioDto salarioDto) {
        Salario salario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Salário não encontrado"));

        if (!Objects.isNull(salarioDto.getCargoId())) {
            Cargo cargo = cargoRepository.findById(salarioDto.getCargoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
            salario.setCargo(cargo);
        }

        salario.setSalario(salarioDto.getSalario());
        salario.setGrade(salarioDto.getGrade());

        return repository.save(salario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        Salario salario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Salário não encontrado"));

        repository.delete(salario);
    }


}
