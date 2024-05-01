package com.saula.api.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saula.api.domain.Matricula;
import com.saula.api.exception.MatriculaNotFoundException;
import com.saula.api.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	public Set<Matricula> findAll(){
		return matriculaRepository.findAll();
	}
	
	@Override
	public Optional<Matricula> findByIdUsuario(long id_usuario){
		return matriculaRepository.findById(id_usuario);
	}
	
	@Override 
	public Matricula addMatricula(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}
	
	@Override
	public Matricula modifyMatricula(long id_usuario, Matricula newMatricula) {
		Matricula matricula = matriculaRepository.findById(id_usuario).orElseThrow(()-> new MatriculaNotFoundException(id_usuario));
		newMatricula.setId_curso(matricula.getId_curso());
		return matriculaRepository.save(newMatricula);
	}
	
	@Override
	public void deleteMatricula(long id_usuario) {
		matriculaRepository.findById(id_usuario).orElseThrow(()-> new MatriculaNotFoundException(id_usuario));
		matriculaRepository.deleteById(id_usuario);
	}
	
}
