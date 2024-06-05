package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saula.api.domain.Contenido;
import com.saula.api.domain.Curso;
import com.saula.api.dto.ContenidoDTO;
import com.saula.api.exception.ContenidoNotFoundException;
import com.saula.api.exception.CursoNotFoundException;
import com.saula.api.repository.ContenidoRepository;
import com.saula.api.repository.CursoRepository;

@Service
public class ContenidoServiceImpl implements ContenidoService{

	@Autowired
	private ContenidoRepository contenidoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Set<Contenido> findAll() {
		return contenidoRepository.findAll();
	}
	
	@Override 
	public Set<Contenido> findByIdCurso(long id_curso) {
		Curso curso = cursoRepository.findById(id_curso).orElseThrow(()-> new CursoNotFoundException(id_curso));
		return contenidoRepository.findByCurso(curso);
	}

	@Override
	public Optional<Contenido> findById(long id) {
		return contenidoRepository.findById(id);
	}

	@Override
	public Contenido addContenido(ContenidoDTO contenidoDTO) {
		Curso curso = cursoRepository.findById(contenidoDTO.getIdCurso())
                .orElseThrow(() -> new CursoNotFoundException(contenidoDTO.getIdCurso()));
		
		Contenido contenido = new Contenido();
		contenido.setTitulo(contenidoDTO.getTitulo());
		contenido.setEnlace(contenidoDTO.getEnlace());
		contenido.setVideo(contenidoDTO.getVideo());
		contenido.setFoto(contenidoDTO.getFoto());
		contenido.setDescripcion(contenidoDTO.getDescripcion());
		contenido.setCurso(curso);
		return contenidoRepository.save(contenido);
	}

	@Override
	public Contenido modifyContenido(long id, ContenidoDTO contendidoDTO) {
		Curso curso = cursoRepository.findById(contendidoDTO.getIdCurso())
                .orElseThrow(() -> new CursoNotFoundException(contendidoDTO.getIdCurso()));
		Contenido newContenido = new Contenido();
		newContenido.setId(id);
		newContenido.setTitulo(contendidoDTO.getTitulo());
		newContenido.setEnlace(contendidoDTO.getEnlace());
		newContenido.setVideo(contendidoDTO.getVideo());
		newContenido.setFoto(contendidoDTO.getFoto());
		newContenido.setDescripcion(contendidoDTO.getDescripcion());
		newContenido.setCurso(curso);
		return contenidoRepository.save(newContenido);
	}

	@Override
	public void deleteContenido(long id) {
		contenidoRepository.findById(id).orElseThrow(()-> new ContenidoNotFoundException(id));
		contenidoRepository.deleteById(id);
		
	}
	

}
