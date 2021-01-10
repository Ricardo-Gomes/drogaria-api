package com.drogaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drogaria.api.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
