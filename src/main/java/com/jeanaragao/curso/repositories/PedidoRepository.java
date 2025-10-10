package com.jeanaragao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanaragao.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
