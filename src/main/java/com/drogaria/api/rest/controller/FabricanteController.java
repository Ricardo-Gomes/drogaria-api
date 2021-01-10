package com.drogaria.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.drogaria.api.entity.Fabricante;
import com.drogaria.api.repository.FabricanteRepository;

@RestController
@RequestMapping("/api/fabricantes")
@CrossOrigin("http://localhost:4200")
public class FabricanteController {

	@Autowired
	private FabricanteRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Fabricante salvar(@RequestBody @Valid Fabricante fabricante) {
		return repository.save(fabricante);
	}

	@GetMapping
	public List<Fabricante> obterTodos() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public Fabricante acharPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository.findById(id).map(fabricante -> {
			repository.delete(fabricante);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid Fabricante fabricanteAtualizado) {
		repository.findById(id).map(fabricante -> {
			fabricanteAtualizado.setId(fabricante.getId());
			return repository.save(fabricanteAtualizado);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}

