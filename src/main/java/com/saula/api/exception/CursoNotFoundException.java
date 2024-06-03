package com.saula.api.exception;

public class CursoNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CursoNotFoundException() {
		super();
	}
	
	public CursoNotFoundException(String message) {
		super(message);
	}
	
	public CursoNotFoundException(long id) {
		super("Curso not found: " +  id);
	}
	

}
