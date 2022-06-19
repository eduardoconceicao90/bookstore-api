package com.projeto.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.bookstore.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
