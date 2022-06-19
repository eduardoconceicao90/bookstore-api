package com.projeto.bookstore.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {

	private Long id;
	private String nome;
	private String nome_autor;
	private String texto;

	private Categoria categoria;

}
