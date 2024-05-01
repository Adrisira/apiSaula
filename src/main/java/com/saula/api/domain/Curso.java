package com.saula.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity(name = "usuario")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@NotNull
	private String nombre;
	@Column
	@NotNull
	private String codigo;
	@Column
	private String descripcion;
	@Column
	private String imagen;
	@Column
	@OneToMany(mappedBy = "id_curso", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Matricula> matriculas;
	@Column
	@OneToMany(mappedBy = "id_contenido", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Contenido> contenidos;
}
