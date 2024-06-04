package com.saula.api.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saula.api.domain.Contenido;
import com.saula.api.domain.Curso;

@Repository
public interface ContenidoRepository extends CrudRepository<Contenido, Long>{
	Set<Contenido> findAll();
	Set<Contenido> findByCurso(Curso curso);
}
