package com.jeanaragao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanaragao.curso.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
