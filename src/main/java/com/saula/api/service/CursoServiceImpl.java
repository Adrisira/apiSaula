package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saula.api.domain.Curso;
import com.saula.api.exception.CursoNotFoundException;
import com.saula.api.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Set<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> findById(long id) {
		return cursoRepository.findById(id);
	}

	@Override
	public Optional<Curso> findByCodigo(String codigo) {
		return cursoRepository.findByCodigo(codigo);
	}
	@Override
	public Curso addCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso modifyCurso(long id, Curso newCurso) {
		Curso curso = cursoRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
		newCurso.setId(curso.getId());
		return cursoRepository.save(newCurso);
	}

	@Override
	public void deleteCurso(long id) {
		cursoRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
		cursoRepository.deleteById(id);
	}

	
}
