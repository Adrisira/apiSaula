package com.saula.api.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.saula.api.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	Set<Usuario> findAll();
}
