package com.saula.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saula.api.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Optional<Usuario> findById(long id);
	
	Optional<Usuario> findByEmail(String email);
	
	
	
	
}
