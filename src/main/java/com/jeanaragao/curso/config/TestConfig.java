package com.jeanaragao.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeanaragao.curso.entities.Categoria;
import com.jeanaragao.curso.entities.Pedido;
import com.jeanaragao.curso.entities.Usuario;
import com.jeanaragao.curso.entities.enums.OrdemPedido;
import com.jeanaragao.curso.repositories.CategoriaRepository;
import com.jeanaragao.curso.repositories.PedidoRepository;
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
		

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 
		
		Usuario u1 = new Usuario(null, "Jean", "jean.aragao@gmail.com", "11994288050", "123456");
		Usuario u2 = new Usuario(null, "João", "joao@gmail.com", "11994288050", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),OrdemPedido.ENTREGUE, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), OrdemPedido.AGUARDANDO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), OrdemPedido.ENVIADO, u1); 
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		
	}
	
	
	
	
}
