package com.projeto.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bookstore.models.Categoria;
import com.projeto.bookstore.models.Livro;
import com.projeto.bookstore.repositories.LivroRepository;
import com.projeto.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Long id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {

		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}

		if (obj.getNome_autor() != null) {
			newObj.setNome_autor(obj.getNome_autor());
		}

		if (obj.getTexto() != null) {
			newObj.setTexto(obj.getTexto());
		}
	}

	public Livro create(Long id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	public void delete(Long id) {
		Livro obj = findById(id);
		livroRepository.delete(obj);
	}
}
