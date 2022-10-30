package com.bookstoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreapi.model.Categoria;
import com.bookstoreapi.model.Livro;
import com.bookstoreapi.repository.LivroRepository;
import com.bookstoreapi.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro buscarPorId(Long id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", tipo: " + Livro.class.getName()));
	}

	public List<Livro> listar(Long id_cat) {
		categoriaService.buscarPorId(id_cat);
		return livroRepository.listarPorCategoria(id_cat);
	}

	public Livro criar(Long id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.buscarPorId(id_cat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}
	
	public Livro atualizar(Long id, Livro obj) {
		Livro newObj = buscarPorId(id);		
		updateData(newObj, obj);
		return livroRepository.save(newObj);		
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public void deletar(Long id) {
		buscarPorId(id);
		livroRepository.deleteById(id);		
	}


}
