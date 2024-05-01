package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import com.saula.api.domain.Usuario;

public interface UsuarioService {

	Set<Usuario> findAll();
	Optional<Usuario> findById(long id);
	Usuario addUsuario(Usuario usuario);
	Usuario modifyUsuario(long id, Usuario newUsuario);
	void deleteUsuario(long id);
	
	
}
