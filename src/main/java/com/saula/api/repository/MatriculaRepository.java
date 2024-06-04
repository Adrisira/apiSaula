package com.saula.api.repository;

import java.util.Set;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saula.api.domain.Curso;
import com.saula.api.domain.Matricula;
import com.saula.api.domain.Usuario;


@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long>{

	Set<Matricula> findAll();
	Set<Matricula> findByUsuario(Usuario usuario);
	Set<Matricula> findByCurso(Curso curso);
}
