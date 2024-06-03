package com.saula.api.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.saula.api.domain.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long>{
	Set<Curso> findAll();
	Optional<Curso> findById(long id);
	Optional<Curso> findByCodigo(String codigo);
}
