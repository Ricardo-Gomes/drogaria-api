package com.drogaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drogaria.api.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
