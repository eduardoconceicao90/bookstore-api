package com.projeto.bookstore.dtos;

import java.io.Serializable;

import com.projeto.bookstore.models.Livro;

import lombok.Data;

@Data
public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public LivroDTO() {

	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

}
