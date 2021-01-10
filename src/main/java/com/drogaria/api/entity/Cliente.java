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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "controle_acesso", name = "cliente")
public class Cliente {

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
	
	@NotEmpty(message = "O campo CPF é obrigatorio.")
	@CPF
	@Column(nullable = false, length = 14)
	private String cpf;
	
	@NotEmpty(message = "O campo RG é obrigatorio.")
	@Column(nullable = false, length = 16)
	private String rg;
	
	@NotEmpty(message = "O campo Estado Civil é obrigatorio.")
	@Column(nullable = false, name = "estado_civil", length = 15)
	private String estadoCivil;
	
	@NotEmpty(message = "O campo Sexo é obrigatorio.")
	@Column(nullable = false, length = 10)
	private String sexo;
	
	@NotNull(message = "O campo Data de Nascimento é obrigatorio.")
	@JsonFormat(pattern = "ddMMyyyy")
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
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
