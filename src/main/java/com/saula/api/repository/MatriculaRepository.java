package com.saula.api.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.saula.api.domain.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Long>{
	Set<Matricula> findAll();
}
