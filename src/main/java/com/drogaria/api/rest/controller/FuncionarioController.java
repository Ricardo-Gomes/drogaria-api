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

import com.drogaria.api.entity.Funcionario;
import com.drogaria.api.repository.FuncionarioRepository;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin("http://localhost:4200")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario salvar(@RequestBody @Valid Funcionario funcionario) {
		return repository.save(funcionario);
	}

	@GetMapping
	public List<Funcionario> obterTodos() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public Funcionario acharPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository.findById(id).map(funcionario -> {
			repository.delete(funcionario);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionarioAtualizado) {
		repository.findById(id).map(funcionario -> {
			funcionarioAtualizado.setId(funcionario.getId());
			return repository.save(funcionarioAtualizado);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}

