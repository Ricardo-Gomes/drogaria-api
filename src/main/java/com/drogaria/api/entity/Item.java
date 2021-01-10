package com.drogaria.api.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "drogaria", name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
    
	@Column(nullable = false, name = "qtd")
    private Double quantidade;
    
	@Column(nullable = false, name = "preco_produto")
    private BigDecimal precoProduto;
    
	@Column(nullable = false, name = "preco_total")
    private BigDecimal precoTotal;
	
	@ManyToOne
	@JoinColumn(name = "fk_produto", referencedColumnName = "id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "fk_venda", referencedColumnName = "id")
	private Venda venda;
}
