package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import com.saula.api.domain.Contenido;
import com.saula.api.dto.ContenidoDTO;

public interface ContenidoService {
	Set<Contenido> findAll();
	Set<Contenido> findByIdCurso(long id_curso);
	Optional<Contenido> findById(long id);
	Contenido addContenido(ContenidoDTO contendioDTO);
	Contenido modifyContenido(long id, Contenido newContenido);
	void deleteContenido(long id);
	
	
}
