package com.saula.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "matricula")
@EqualsAndHashCode
@IdClass(MatriculaPK.class)
public class Matricula {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario id_usuario;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_curso", referencedColumnName = "id")
	private Curso id_curso;

	@Column
	private String rol;

	@Column
	private Boolean apariencia;

}
