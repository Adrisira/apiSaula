package com.saula.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saula.api.domain.Curso;
import com.saula.api.exception.CursoNotFoundException;
import com.saula.api.service.CursoService;

@RestController
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/curso")
	public ResponseEntity<Set<Curso>> getCursos(){
		Set<Curso> cursos = null;
		cursos = cursoService.findAll();
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	
	@GetMapping("/curso/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable long id){
		Curso curso = cursoService.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}
	
	@PostMapping(value="/curso", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curso) {
        Curso addedCurso = cursoService.addCurso(curso);
        return new ResponseEntity<>(addedCurso, HttpStatus.CREATED);
    }
	
	@PutMapping(value="/curso/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> modifyCurso(@PathVariable long id, @RequestBody Curso newCurso) {
		Curso curso = cursoService.modifyCurso(id, newCurso);
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}
	
	@DeleteMapping("/autor/{id}")
	public ResponseEntity<Response> deleteCurso(@PathVariable long id) {
		cursoService.deleteCurso(id);
		return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
	}
	
	@ExceptionHandler(CursoNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(CursoNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
