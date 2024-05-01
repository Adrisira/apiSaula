package com.saula.api.domain;

import java.util.Objects;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MatriculaPK {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario id_usuario;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_curso", referencedColumnName = "id")
	private Curso id_curso;

	public MatriculaPK() {
		super();
	}
	
	public MatriculaPK(Usuario id_usuario, Curso id_curso) {
		super();
		this.id_usuario = id_usuario;
		this.id_curso = id_curso;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Curso getId_curso() {
		return id_curso;
	}

	public void setId_curso(Curso id_curso) {
		this.id_curso = id_curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_curso, id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaPK other = (MatriculaPK) obj;
		return Objects.equals(id_curso, other.id_curso) && Objects.equals(id_usuario, other.id_usuario);
	}
	
	

	
	
	
}
