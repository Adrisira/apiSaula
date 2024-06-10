package com.saula.api.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saula.api.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Set<Usuario> findAll();
	Optional<Usuario> findById(long id);
	Optional<Usuario> findByEmail(String email);
	
	
	
	
}
