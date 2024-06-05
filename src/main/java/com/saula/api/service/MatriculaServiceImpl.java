package com.saula.api.service;

import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saula.api.domain.Curso;
import com.saula.api.domain.Matricula;
import com.saula.api.domain.Usuario;
import com.saula.api.dto.MatriculaDTO;
import com.saula.api.exception.CursoNotFoundException;
import com.saula.api.exception.MatriculaNotFoundException;
import com.saula.api.exception.UsuarioNotFoundException;
import com.saula.api.repository.CursoRepository;
import com.saula.api.repository.MatriculaRepository;
import com.saula.api.repository.UsuarioRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Set<Matricula> findAll(){
		return matriculaRepository.findAll();
	}
	@Override
	public Optional<Matricula> findById(long id) {
		return matriculaRepository.findById(id);
	}
	@Override
	public Set<Matricula> findByIdUsuario(long id_usuario) {
		Usuario usuario = usuarioRepository.findById(id_usuario).orElseThrow(() -> new UsuarioNotFoundException(id_usuario));
	        return matriculaRepository.findByUsuario(usuario);
	}
	@Override
	public Set<Matricula> findByIdCurso(long id_curso) {
		Curso curso = cursoRepository.findById(id_curso).orElseThrow(()-> new CursoNotFoundException(id_curso));
		return matriculaRepository.findByCurso(curso);
	}
	
	@Override 
	public Matricula addMatricula(MatriculaDTO matriculaDTO) {
		Usuario usuario = usuarioRepository.findById(matriculaDTO.getIdUsuario())
                .orElseThrow(() -> new UsuarioNotFoundException(matriculaDTO.getIdUsuario()));
        Curso curso = cursoRepository.findById(matriculaDTO.getIdCurso())
                .orElseThrow(() -> new CursoNotFoundException(matriculaDTO.getIdCurso()));
        
        Matricula matricula = new Matricula();
        matricula.setRol(matriculaDTO.isRol());
        matricula.setUsuario(usuario);
        matricula.setCurso(curso);

        return matriculaRepository.save(matricula);
	}
	
	@Override
	public Matricula modifyMatricula(long id, Matricula newMatricula) {
		Matricula matricula = matriculaRepository.findById(id).orElseThrow(()-> new MatriculaNotFoundException(id));
		newMatricula.setId(matricula.getId());
		return matriculaRepository.save(newMatricula);
	}
	
	@Override
	public void deleteMatricula(long id) {
		Matricula matricula = matriculaRepository.findById(id).orElseThrow(() -> new MatriculaNotFoundException(id));
	    matriculaRepository.delete(matricula);
	}
	



	
	
}
