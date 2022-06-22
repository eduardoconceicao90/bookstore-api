package com.projeto.bookstore.dtos;

import java.io.Serializable;

import com.projeto.bookstore.models.Categoria;

import lombok.Data;

@Data
public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descricao;
	
	public CategoriaDTO() {
	
	}
	
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

}
