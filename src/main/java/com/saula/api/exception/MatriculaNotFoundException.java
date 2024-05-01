package com.saula.api.exception;

public class MatriculaNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public MatriculaNotFoundException() {
		super ();
	}
	
	public MatriculaNotFoundException(String message) {
		super (message);
	}
	
	public MatriculaNotFoundException(long id) {
		super ("Matricula not found: " + id);
	}

}
