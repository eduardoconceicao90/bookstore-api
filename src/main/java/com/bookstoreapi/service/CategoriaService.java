package com.bookstoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstoreapi.dto.CategoriaDTO;
import com.bookstoreapi.model.Categoria;
import com.bookstoreapi.repository.CategoriaRepository;
import com.bookstoreapi.service.exception.DataIntegratyViolationException;
import com.bookstoreapi.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", tipo: " + Categoria.class.getName()));	
	}
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	public Categoria criar(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);		
	}

	public Categoria atualizar(Long id, CategoriaDTO objDto) {
		Categoria obj = buscarPorId(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);		
	}
	
	public void deletar(Long id) {
		buscarPorId(id);
		try {
			categoriaRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegratyViolationException(
					"Categoria não pode ser deletada! Possui livros associados");
		}
	}
	
}
