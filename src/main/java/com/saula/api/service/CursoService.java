package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import com.saula.api.domain.Curso;
public interface CursoService {

	Set<Curso> findAll();
	Optional<Curso> findById(long id);
	Optional<Curso> findByCodigo(String codigo);
	Curso addCurso(Curso curso);
	Curso modifyCurso(long id, Curso newCurso);
	void deleteCurso(long id);
}
