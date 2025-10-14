package com.jeanaragao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanaragao.curso.entities.ItemPedido;
import com.jeanaragao.curso.entities.pk.ItemPedidoPk;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPk> {

}
