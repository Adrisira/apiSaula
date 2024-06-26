package com.saula.api.controller;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.saula.api.domain.Matricula;
import com.saula.api.dto.MatriculaDTO;
import com.saula.api.exception.MatriculaNotFoundException;
import com.saula.api.service.MatriculaService;

@RestController
@CrossOrigin(origins = "*")
public class MatriculaController {
	
	@Autowired 
	private MatriculaService matriculaService;
	
	@GetMapping("/matricula")
	public ResponseEntity<Set<Matricula>> getMatriculas(){
		Set<Matricula> matriculas = null;
		matriculas = matriculaService.findAll();
		return new ResponseEntity<>(matriculas, HttpStatus.OK);
	}
	
	@GetMapping("/matricula/{id}")
	public ResponseEntity<Matricula> getMatricula(@PathVariable long id){
		Matricula matricula = matriculaService.findById(id).orElseThrow(()-> new MatriculaNotFoundException(id));
		return new ResponseEntity<>(matricula, HttpStatus.OK); 
	}
	
	@GetMapping("/matriculaUsuario/{id}")
	public ResponseEntity<Set<Matricula>> getMatriculasUsuario(@PathVariable long id){
		Set<Matricula> matriculas = matriculaService.findByIdUsuario(id);
		return new ResponseEntity<>(matriculas, HttpStatus.OK);
	}
	
	@GetMapping("/matriculaCurso/{id}")
	public ResponseEntity<Set<Matricula>> getMatriculasCurso(@PathVariable long id){
		Set<Matricula> cursos = matriculaService.findByIdCurso(id);
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	
	@PostMapping(value="/crearMatricula", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Matricula> addMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        Matricula addedMatricula = matriculaService.addMatricula(matriculaDTO);
        return new ResponseEntity<>(addedMatricula, HttpStatus.CREATED);
    }
	
	@PutMapping(value="/matricula/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Matricula> modifyMatricula(@PathVariable long id_Usuario, @RequestBody Matricula newMatricula) {
		Matricula matricula = matriculaService.modifyMatricula(id_Usuario, newMatricula);
		return new ResponseEntity<>(matricula, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteMatricula/{id}")
	public ResponseEntity<Response> deleteMatricula(@PathVariable long id) {
		 try {
		        matriculaService.deleteMatricula(id);
		        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
		    } catch (MatriculaNotFoundException e) {
		        return new ResponseEntity<>(Response.errorResonse(Response.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
		    } 
	}
	
	@ExceptionHandler(MatriculaNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(MatriculaNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
