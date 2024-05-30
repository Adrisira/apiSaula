package com.saula.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "contenido")
public class Contenido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull
	private String titulo;
	@Column
	private String enlace;
	@Column
	private String video;
	@Column
	private String foto;
	@Column
	private String descripcion;
	@Column
	private int orden;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "curso_codigo", referencedColumnName = "id")
	private Curso id_curso;
}
