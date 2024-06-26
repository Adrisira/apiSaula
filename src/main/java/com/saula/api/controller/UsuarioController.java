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

import com.saula.api.domain.LoginRequest;
import com.saula.api.domain.RequestEmail;
import com.saula.api.domain.Usuario;
import com.saula.api.exception.UsuarioNotFoundException;
import com.saula.api.service.UsuarioService;
@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<Set<Usuario>> getUsuarios(){
		Set<Usuario> usuarios = null;
		usuarios = usuarioService.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
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
    public ResponseEntity<Boolean> existsByEmail(@RequestBody RequestEmail emailRequest) {
        Boolean existe = usuarioService.existsByEmail(emailRequest.getEmail());
        return new ResponseEntity<>(existe, HttpStatus.OK);
    }
	
	@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest login) {
        Long idUser = usuarioService.login(login.getEmail(), login.getPassword());
        Usuario user = usuarioService.findById(idUser).orElseThrow(()-> new UsuarioNotFoundException(idUser));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	@PutMapping(value="/usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> modifyUsuario(@PathVariable long id, @RequestBody Usuario newUsuario) {
		Usuario usuario = usuarioService.modifyUsuario(id, newUsuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUsuario/{id}")
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
