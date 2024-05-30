package com.saula.api.repository;

import java.util.Optional;
import java.util.Set;


import org.springframework.data.repository.CrudRepository;

import com.saula.api.domain.Curso;
import com.saula.api.domain.Matricula;
import com.saula.api.domain.Usuario;


public interface MatriculaRepository extends CrudRepository<Matricula, Long>{

	Set<Matricula> findAll();
	Optional<Matricula> findById(long id);
	Set<Matricula> findByUsuario(Usuario usuario);
	Set<Matricula> findByCurso(Curso curso);
}
