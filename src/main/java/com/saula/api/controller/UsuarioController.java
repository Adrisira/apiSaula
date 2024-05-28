package com.saula.api.controller;



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

import com.saula.api.domain.LoginRequest;
import com.saula.api.domain.Usuario;
import com.saula.api.exception.UsuarioNotFoundException;
import com.saula.api.service.UsuarioService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable long id){
		Usuario usuario = usuarioService.findById(id).orElseThrow(()-> new UsuarioNotFoundException(id));
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@PostMapping(value="/registrer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario addedUsuario = usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(addedUsuario, HttpStatus.CREATED);
    }
	
	@PostMapping(value="/existEmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByEmail(@RequestBody String email) {
        Boolean existe = usuarioService.existsByEmail(email);
        return new ResponseEntity<>(existe, HttpStatus.OK);
    }
	
	@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest login) {
        Boolean inicia = usuarioService.login(login.getEmail(), login.getPassword());
        return new ResponseEntity<>(inicia, HttpStatus.OK);
    }
	@PutMapping(value="/usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> modifyUsuario(@PathVariable long id, @RequestBody Usuario newUsuario) {
		Usuario usuario = usuarioService.modifyUsuario(id, newUsuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Response> deleteUsuario(@PathVariable long id) {
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
	}
	
	@ExceptionHandler(UsuarioNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(UsuarioNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
