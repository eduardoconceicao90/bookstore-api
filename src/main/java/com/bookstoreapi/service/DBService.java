package com.bookstoreapi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreapi.model.Categoria;
import com.bookstoreapi.model.Livro;
import com.bookstoreapi.repository.CategoriaRepository;
import com.bookstoreapi.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaDB() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l3));
		cat2.getLivros().addAll(Arrays.asList(l2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3));
	}
}
