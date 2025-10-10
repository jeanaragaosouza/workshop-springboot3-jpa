package com.jeanaragao.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeanaragao.curso.entities.Usuario;
import com.jeanaragao.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Jean", "jean.aragao@gmail.com", "11994288050", "123456");
		Usuario u2 = new Usuario(null, "João", "joao@gmail.com", "11994288050", "123456");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
	
	
}
