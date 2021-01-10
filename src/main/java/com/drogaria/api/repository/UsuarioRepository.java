package com.drogaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drogaria.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
