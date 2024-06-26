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

import com.saula.api.domain.Contenido;
import com.saula.api.dto.ContenidoDTO;
import com.saula.api.exception.ContenidoNotFoundException;
import com.saula.api.service.ContenidoService;

@RestController
@CrossOrigin(origins = "*")
public class ContenidoController {

	@Autowired
	private ContenidoService contenidoService;
	
	@GetMapping("/contenido")
	public ResponseEntity<Set<Contenido>> getContenidoss(){
		Set<Contenido> contenidos = null;
			contenidos = contenidoService.findAll();
		
		return new ResponseEntity<>(contenidos, HttpStatus.OK);
	}
	
	@GetMapping("/contenido/{id}")
	public ResponseEntity<Contenido> getContenido(@PathVariable long id){
		Contenido contenido = contenidoService.findById(id).orElseThrow(()-> new ContenidoNotFoundException(id));
		return new ResponseEntity<>(contenido, HttpStatus.OK);
	}
	
	@GetMapping("/contenidoCurso/{id}")
	public ResponseEntity<Set<Contenido>> getContenidoCurso(@PathVariable long id){
		Set<Contenido> contenidos = contenidoService.findByIdCurso(id);
		return new ResponseEntity<>(contenidos, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/crearContenido", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contenido> addContenido(@RequestBody ContenidoDTO contenidoDTO) {
        Contenido addedContenido = contenidoService.addContenido(contenidoDTO);
        return new ResponseEntity<>(addedContenido, HttpStatus.CREATED);
    }
	
	@PutMapping(value="/modifyContenido/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contenido> modifyContenido(@PathVariable long id, @RequestBody ContenidoDTO contendioDTO) {
		Contenido contenido = contenidoService.modifyContenido(id, contendioDTO);
		return new ResponseEntity<>(contenido, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteContenido/{id}")
	public ResponseEntity<Response> deleteContenido(@PathVariable long id) {
		contenidoService.deleteContenido(id);
		return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
	}
	
	@ExceptionHandler(ContenidoNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(ContenidoNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
