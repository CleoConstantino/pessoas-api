package com.cleo.gestao.pessoas.controllers;

import com.cleo.gestao.pessoas.dtos.ColaboradorDto;
import com.cleo.gestao.pessoas.entities.Cargo;
import com.cleo.gestao.pessoas.entities.Colaborador;
import com.cleo.gestao.pessoas.repositories.CargoRepository;
import com.cleo.gestao.pessoas.repositories.ColaboradorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    private final ColaboradorRepository repository;
    private final CargoRepository cargoRepository;

    public ColaboradorController(ColaboradorRepository repository, CargoRepository cargoRepository) {
        this.repository = repository;
        this.cargoRepository = cargoRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Colaborador save(@Valid @RequestBody ColaboradorDto colaboradorDto) {
        Colaborador colaborador = new Colaborador();

        if (!Objects.isNull(colaboradorDto.getCargoId())) {
            Cargo cargo = cargoRepository.findById(colaboradorDto.getCargoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
            colaborador.setCargo(cargo);
        }

        colaborador.setNome(colaboradorDto.getNome());
        colaborador.setCpf(colaboradorDto.getCpf());
        colaborador.setIdade(colaboradorDto.getIdade());
        colaborador.setDataNascimento(colaboradorDto.getDataNascimento());

        return repository.save(colaborador);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Colaborador findById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Colaborador update(@PathVariable("id") Long id, @Valid @RequestBody ColaboradorDto colaboradorDto) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado"));

        if (!Objects.isNull(colaboradorDto.getCargoId())) {
            Cargo cargo = cargoRepository.findById(colaboradorDto.getCargoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
            colaborador.setCargo(cargo);
        }

        colaborador.setNome(colaboradorDto.getNome());
        colaborador.setCpf(colaboradorDto.getCpf());
        colaborador.setIdade(colaboradorDto.getIdade());
        colaborador.setDataNascimento(colaboradorDto.getDataNascimento());

        return repository.save(colaborador);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado"));

        repository.delete(colaborador);
    }


}
