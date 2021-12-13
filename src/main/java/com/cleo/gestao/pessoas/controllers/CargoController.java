package com.cleo.gestao.pessoas.controllers;

import com.cleo.gestao.pessoas.dtos.CargoDto;
import com.cleo.gestao.pessoas.entities.Cargo;
import com.cleo.gestao.pessoas.repositories.CargoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoRepository repository;

    public CargoController(CargoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cargo save(@Valid @RequestBody CargoDto cargoDto) {
        Cargo cargo = new Cargo();

        cargo.setNome(cargoDto.getNome());
        cargo.setDescricao(cargoDto.getDescricao());

        return repository.save(cargo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cargo findById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Cargo update(@PathVariable("id") Long id, @Valid @RequestBody CargoDto cargoDto) {
        Cargo cargo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));

        cargo.setNome(cargoDto.getNome());
        cargo.setDescricao(cargoDto.getDescricao());

        return repository.save(cargo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        Cargo cargo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));

        repository.delete(cargo);
    }

}
