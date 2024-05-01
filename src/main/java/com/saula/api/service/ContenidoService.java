package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import com.saula.api.domain.Contenido;

public interface ContenidoService {
	Set<Contenido> findAll();
	Optional<Contenido> findById(long id);
	Contenido addContenido(Contenido contendio);
	Contenido modifyContenido(long id, Contenido newContenido);
	void deleteContenido(long id);
	
	
}
