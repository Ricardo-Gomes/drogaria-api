package com.drogaria.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.drogaria.api.entity.Produto;
import com.drogaria.api.repository.FabricanteRepository;
import com.drogaria.api.repository.ProdutoRepository;
import com.drogaria.api.rest.dto.ProdutoDTO;
import com.drogaria.api.util.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProdutoController {

	private final ProdutoRepository repository;
	private final FabricanteRepository fabricanteRepository;
	private final BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvar(@RequestBody @Valid ProdutoDTO dto) {

		Long idFabricante = dto.getIdFabricante();

		Fabricante fabricante = fabricanteRepository.findById(idFabricante)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fabricante Inexistente"));

		Produto produto = new Produto();

		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setEstoque(dto.getEstoque());
		produto.setCategoria(dto.getCategoria());
		produto.setMarca(dto.getMarca());
		produto.setValorVenda(dto.getValorVenda());
		produto.setValorCusto(dto.getValorCusto());
		produto.setFabricante(fabricante);

		return repository.save(produto);
	}
	
	@GetMapping
	public List<Produto> obterTodos(){
		return repository.findAll();
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository.findById(id).map(produto -> {
			repository.delete(produto);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid Produto produtoAtualizado) {
		repository.findById(id).map(produto -> {
			produtoAtualizado.setId(produto.getId());
			return repository.save(produtoAtualizado);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping("{id}")
	public Produto acharPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}

