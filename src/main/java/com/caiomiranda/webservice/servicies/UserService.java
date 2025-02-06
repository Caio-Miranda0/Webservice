package com.caiomiranda.webservice.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Apesar desses métodos apenas repassarem para a interface UserRepository, vou
	// manter UserService, pois futuramente pode-se implementar alguma
	// lógica/regra de negócio.

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		// O usuário pode ou não existir:
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

}
