package com.drogaria.api.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "drogaria", name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JsonFormat(pattern = "ddMMyyyy")
	@Column(name = "dt_venda", updatable = false)
	private LocalDate dataVenda;
	
	@Column(nullable = false, name = "vl_total")
	private BigDecimal valorTotal;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "venda")
	private List<Item> itens;
	
	@ManyToOne
	@JoinColumn(name = "fk_funcionario", referencedColumnName = "id")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@PrePersist
	public void prePersist() {
		setDataVenda(LocalDate.now());
	}
}
