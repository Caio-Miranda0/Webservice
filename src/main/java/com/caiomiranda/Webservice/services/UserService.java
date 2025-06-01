package com.caiomiranda.Webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiomiranda.Webservice.entities.User;
import com.caiomiranda.Webservice.repositories.UserRepository;

@Service // Registro semântico de um componente Spring
public class UserService {
	
	@Autowired // Faz a injeção da dependência
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll(); // retorna uma lista de usuários
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id); // retorna um objeto do tipo Optional<T>
		return obj.get(); // retorna um objeto de acordo com o tipo preenchido no Generic. No caso, User.
	}
	
}
