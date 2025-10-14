package com.jeanaragao.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeanaragao.curso.entities.Categoria;
import com.jeanaragao.curso.entities.ItemPedido;
import com.jeanaragao.curso.entities.Pedido;
import com.jeanaragao.curso.entities.Produto;
import com.jeanaragao.curso.entities.Usuario;
import com.jeanaragao.curso.entities.enums.OrdemPedido;
import com.jeanaragao.curso.repositories.CategoriaRepository;
import com.jeanaragao.curso.repositories.ItemPedidoRepository;
import com.jeanaragao.curso.repositories.PedidoRepository;
import com.jeanaragao.curso.repositories.ProdutoRepository;
import com.jeanaragao.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository; 
		

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		
		Usuario u1 = new Usuario(null, "Jean", "jean.aragao@gmail.com", "11994288050", "123456");
		Usuario u2 = new Usuario(null, "João", "joao@gmail.com", "11994288050", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),OrdemPedido.ENTREGUE, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), OrdemPedido.AGUARDANDO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), OrdemPedido.ENVIADO, u1); 
		

		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreco());
		ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreco());
		ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreco());
		ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreco());
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		itemPedidoRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		
	}
	
	
	
	
}
