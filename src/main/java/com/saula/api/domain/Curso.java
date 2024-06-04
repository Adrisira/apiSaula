package com.saula.api.domain;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@NotNull
	private String nombre;
	@NotNull
	@Column(unique=true)
	private String codigo;
	@Column
	private String descripcion;
	@Column
	private String imagen;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "curso", orphanRemoval = true)
	@JsonIgnoreProperties("curso")
	private List<Matricula> matriculas;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", orphanRemoval = true)
	@JsonIgnoreProperties(value="curso")
	private List<Contenido> contenidos;
}
