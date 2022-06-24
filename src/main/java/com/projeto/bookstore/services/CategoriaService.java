package com.projeto.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projeto.bookstore.dtos.CategoriaDTO;
import com.projeto.bookstore.models.Categoria;
import com.projeto.bookstore.repositories.CategoriaRepository;
import com.projeto.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Long id, CategoriaDTO objDto) {
		Categoria newObj = findById(id);
		newObj.setNome(objDto.getNome());
		newObj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(newObj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);		
		} catch (DataIntegrityViolationException e) {
			throw new com.projeto.bookstore.services.exceptions.DataIntegrityViolationException(
					"Categoria não pode ser deletada! Possui livros associados");
		}
	}
}
