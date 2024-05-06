package com.saula.api.service;

import java.util.Optional;

import com.saula.api.domain.Usuario;

public interface UsuarioService {
	Optional<Usuario> findById(long id);
	Optional<Usuario> findByEmail(String email);
	Boolean login(String email, String password);
	Boolean existsByEmail(String email);
	Usuario addUsuario(Usuario usuario);
	Usuario modifyUsuario(long id, Usuario newUsuario);
	void deleteUsuario(long id);
	
	
}
