package com.jeanaragao.curso.entities;

import java.io.Serializable;

import com.jeanaragao.curso.entities.pk.ItemPedidoPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPk id;
	private Integer quantidade;
	private double preco;
	
	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, double preco) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		id.setPedido(pedido);
		id.setProduto(produto);
	}

	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);;
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
