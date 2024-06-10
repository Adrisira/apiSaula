package com.saula.api.service;

import java.util.Optional;

import com.saula.api.domain.Usuario;

public interface UsuarioService {
	Optional<Usuario> findById(long id);
	Long login(String email, String password);
	Optional<Usuario> findByEmail(String email);
	Boolean existsByEmail(String email);
	Usuario addUsuario(Usuario usuario);
	Usuario modifyUsuario(long id, Usuario newUsuario);
	void deleteUsuario(long id);
	
	
}
