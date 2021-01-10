package com.drogaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drogaria.api.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
