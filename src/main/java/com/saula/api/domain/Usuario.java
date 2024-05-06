package com.saula.api.domain;

import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	@NotNull
	private String email;
	@Column
	private String password;
	@Column
	@NotNull
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private int edad;
	@Column
	private String dirImg;
	@OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Matricula> matriculas;
}
