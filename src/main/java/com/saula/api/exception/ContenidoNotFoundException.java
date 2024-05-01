package com.saula.api.exception;

public class ContenidoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ContenidoNotFoundException() {
		super();
	}
	
	public ContenidoNotFoundException(String message) {
		super(message);
	}
	
	public ContenidoNotFoundException(long id) {
		super("Contenido not found: " + id);
	}
}
