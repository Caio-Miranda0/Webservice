package com.caiomiranda.webservice.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		List<User> user = new ArrayList<>();
		user.add(new User(null, "Caio", "caio@gmail.com", "62999990000", "abc123"));
		user.add(new User(null, "Letícia", "leticia@gmail.com", "21999991111", "asdf1234"));
		user.add(new User(null, "Jéssica", "jessica@gmail.com", "71978670000", "aaws23"));
		this.userRepository.saveAll(user);
		
	}

}
