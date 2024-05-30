package com.saula.api.service;

import java.util.Optional;
import java.util.Set;


import com.saula.api.domain.Matricula;
import com.saula.api.dto.MatriculaDTO;
public interface MatriculaService {

	Set<Matricula> findAll();
	Optional<Matricula> findById(long id);
	Set<Matricula> findByIdUsuario(long id_usuario);
	Set<Matricula> findByIdCurso(long id_curso);
	Matricula addMatricula(MatriculaDTO matriculaDTO);
	Matricula modifyMatricula(long id, Matricula newMatricula);
	void deleteMatricula(long id);
	
}
