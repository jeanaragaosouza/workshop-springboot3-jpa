package com.jeanaragao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanaragao.curso.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
