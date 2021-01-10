package com.drogaria.api.rest.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
	
	private String nome;
	private String descricao;
	private Integer estoque;
	private String categoria;
	private String marca;
	private BigDecimal valorVenda;
	private BigDecimal valorCusto;
	private Long idFabricante;

}
