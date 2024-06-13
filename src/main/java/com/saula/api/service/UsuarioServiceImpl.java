package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saula.api.domain.Usuario;
import com.saula.api.exception.UsuarioNotFoundException;
import com.saula.api.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(long id) {
		return usuarioRepository.findById(id);
	}
	public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
	}

	@Override
	public Set<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	

	@Override
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario modifyUsuario(long id, Usuario newUsuario) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
		newUsuario.setId(usuario.getId());
		return usuarioRepository.save(newUsuario);
	}

	@Override
	public void deleteUsuario(long id) {
		usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
		usuarioRepository.deleteById(id);
	}

	@Override
	public Boolean existsByEmail(String email) {
		boolean respuesta = false;
		if (!usuarioRepository.findByEmail(email).isEmpty()) {
			respuesta = true;
		}
		return respuesta;
	}

	@Override
	public Long login(String email, String password) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
		Long idUser = -1L;
		if(usuarioOptional
                .map(usuario -> usuario.getPassword().equals(password))
                .orElse(false)) {
			 idUser = usuarioOptional.stream().findFirst().get().getId();
			
		}
        return idUser;
    }

}
