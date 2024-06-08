package com.saula.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.saula.api.domain.Curso;
import com.saula.api.domain.Matricula;
import com.saula.api.domain.Usuario;


@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long>{

	Set<Matricula> findAll();
	Set<Matricula> findByUsuario(Usuario usuario);
	Set<Matricula> findByCurso(Curso curso);
	@Query(value="delete from matricula where id = :id", nativeQuery = true)
	void deletematriculaById(@Param("id") long id);
}
