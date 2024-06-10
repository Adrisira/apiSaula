package com.saula.api.domain;

import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import lombok.ToString;

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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true )
	@JsonIgnoreProperties("usuario")
	@ToString.Exclude
	private List<Matricula> matriculas;
}
