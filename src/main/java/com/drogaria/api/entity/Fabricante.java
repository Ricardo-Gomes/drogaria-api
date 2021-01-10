package com.drogaria.api.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "drogaria", name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@JsonFormat(pattern = "ddMMyyyy")
	@Column(name = "dt_cadastro", updatable = false)
	private LocalDate dataCadastro;

	@NotEmpty(message = "O campo Nome é obrigatorio.")
	@Column(nullable = false, length = 150)
	private String nome;
	
	@NotEmpty(message = "O campo Inscrição Estadual é obrigatorio.")
	@Column(name = "inscricao_estadual", nullable = false, length = 15)
	private String inscricaoEstadual;
	
	@CNPJ(message = "CNPJ inválido")
	@NotEmpty(message = "O campo CNPJ é obrigatorio.")
	@Column(nullable = false, length = 18)
	private String cnpj;
	
	@NotEmpty(message = "O campo Categoria é obrigatorio.")
	@Column(nullable = false, length = 50)
	private String categoria;
	
	@Column(length = 13)
	private String telefone;
	
	@Column(nullable = false, length = 14)
	private String celular;
	
	@Email
	@NotEmpty(message = "O campo Email é obrigatorio.")
	@Column(nullable = false, length = 100)
	private String email;
	
	@NotEmpty(message = "O campo Endereço é obrigatorio")
	@Column(length = 100, nullable = false)
	private String endereco;
	
	@NotEmpty(message = "O campo Número é obrigatorio")
	@Column(length = 10, nullable = false)
	private String numero;

	@Column(length = 30)
	private String complemento;

	@NotEmpty(message = "O campo Cep é obrigatorio")
	@Column(length = 10, nullable = false)
	private String cep;

	@NotEmpty(message = "O campo Bairro é obrigatorio")
	@Column(length = 100, nullable = false)
	private String bairro;

	@NotEmpty(message = "O campo Cidade é obrigatorio.")
	@Column(nullable = false, length = 50)
	private String cidade;

	@NotEmpty(message = "O campo Estado é obrigatorio.")
	@Column(length = 2, nullable = false)
	private String estado;
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
}
