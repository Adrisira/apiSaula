package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import com.saula.api.domain.Matricula;
public interface MatriculaService {

	Set<Matricula> findAll();
	Optional<Matricula> findByIdUsuario(long id_usuario);
	Matricula addMatricula(Matricula matricula);
	Matricula modifyMatricula(long id_usuario, Matricula newMatricula);
	void deleteMatricula(long id_usuario);
	
}
