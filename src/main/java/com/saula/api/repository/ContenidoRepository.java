package com.saula.api.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;


import com.saula.api.domain.Contenido;

public interface ContenidoRepository extends CrudRepository<Contenido, Long>{
	Set<Contenido> findAll();
}
