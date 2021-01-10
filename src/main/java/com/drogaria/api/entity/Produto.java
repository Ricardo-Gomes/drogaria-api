package com.drogaria.api.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "drogaria", name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@JsonFormat(pattern = "ddMMyyyy")
	@Column(name = "dt_cadastro", updatable = false)
	private LocalDate dataCadastro;

	@NotEmpty(message = "O campo Nome é obrigatorio")
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Column(length = 50)
	private String descricao;

	@NotNull(message = "O campo Estoque é obrigatorio.")
	@Column(nullable = false)
	private Integer estoque;
	
	@NotEmpty(message = "O campo Categoria é obrigatorio")
	@Column(nullable = false, length = 50)
	private String categoria;
	
	@NotEmpty(message = "O campo Marca é obrigatorio")
	@Column(nullable = false, length = 50)
	private String marca;

	@NotNull(message = "O campo Valor Venda é obrigatorio.")
	@Column(nullable = false, name = "vl_venda")
	private BigDecimal valorVenda;

	@NotNull(message = "O campo Valor Custo é obrigatorio.")
	@Column(nullable = false, name = "vl_custo")
	private BigDecimal valorCusto;

	@ManyToOne
	@JoinColumn(name = "fk_fabricante", referencedColumnName = "id")
	private Fabricante fabricante;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
	
}
