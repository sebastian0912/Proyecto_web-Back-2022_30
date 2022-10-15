package com.Back;

import com.Back.modelo.Usuario;
import com.Back.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TuAlianzaApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(TuAlianzaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*try{
			Usuario usuario = new Usuario();
			usuario.setNombre("Sebastian");
			usuario.setApellido("Soto");
			usuario.setUsername("prueba");
			usuario.setPassword("12345");
			usuario.setEmail("prueba@gmail.com");

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
			System.out.println(usuarioGuardado.getUsername());
		}catch (Exception exception){
			exception.printStackTrace();
		}*/
	}
}