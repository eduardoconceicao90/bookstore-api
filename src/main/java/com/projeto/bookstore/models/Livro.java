package com.projeto.bookstore.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo NOME é requerido")
	@Length(min = 3, max = 50, message = "O Campo NOME deve ter entre 3 e 50 caracteres")
	private String nome;

	@NotEmpty(message = "Campo NOME DO AUTOR é requerido")
	@Length(min = 3, max = 50, message = "O Campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
	private String nome_autor;

	@NotEmpty(message = "Campo TEXTO é requerido")
	@Length(min = 10, max = 2000000, message = "O Campo TEXTO deve ter entre 10 e 2.000.000 caracteres")
	private String texto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

}
