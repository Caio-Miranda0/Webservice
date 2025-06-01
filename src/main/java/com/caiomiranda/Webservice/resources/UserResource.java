package com.caiomiranda.Webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiomiranda.Webservice.entities.User;
import com.caiomiranda.Webservice.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired // Injeta a dependência
	private UserService userService;

	@GetMapping // Response a requisões do tipo GET.
	public ResponseEntity<List<User>> findAll() {
		List<User> user = userService.findAll();
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/{id}") // Response a requisões do tipo GET com passagem de parâmetro.
	public ResponseEntity<User> findById(@PathVariable Long id) { // Usa o parâmetro da request como argumento do método findById.
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
