package com.saula.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private Boolean rol;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties("matriculas")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	@JsonIgnoreProperties("cursos")
	private Curso curso;
}
