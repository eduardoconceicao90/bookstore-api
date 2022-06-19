package com.projeto.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {

	private Long id;
	private String nome;
	private String descricao;

	private List<Livro> livros = new ArrayList<>();

}
