package com.ejemplo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ejemplo.model.Usuario;
import com.ejemplo.repo.IUsuarioRepo;

@SpringBootTest
class DemoWebApplicationTests {
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {
		
		//Crea un usuario en BBDD para acceso a la aplicacion
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("prueba");
		usuario.setClave(encoder.encode("123"));
		
		Usuario usu = repo.save(usuario);
		
		assertThat(usu.getClave()).isEqualTo(usuario.getClave());
	}

}
