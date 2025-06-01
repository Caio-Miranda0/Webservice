package com.caiomiranda.Webservice.configurations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caiomiranda.Webservice.entities.User;
import com.caiomiranda.Webservice.repositories.UserRepository;

@Configuration // Define que essa classe é uma classe de configuração para o perfil de test,
				// definido no application.properties
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // Faz a injeção de dependencia
	private UserRepository userRepository;

	@Override // O método RUN é executado sempre que a aplicação é iniciada.
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
