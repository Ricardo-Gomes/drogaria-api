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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "drogaria", name = "caixa")
public class Caixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dt_abertura", nullable = false)
	private LocalDate dataAbertura;

	@Column(name = "dt_fechamento", nullable = true)
	private LocalDate dataFechamento;

	@Column(name = "vl_abertura", nullable = false)
	private BigDecimal valorAbertura;
	
	@ManyToOne
	@JoinColumn(name = "fk_funcionario", referencedColumnName = "id", nullable = false)
	private Funcionario funcionario;
}
