package com.caiomiranda.Webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiomiranda.Webservice.entities.Category;
import com.caiomiranda.Webservice.repositories.CategoryRepository;

@Service // Registro semântico de um componente Spring
public class CategoryService {
	
	@Autowired // Faz a injeção da dependência
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll(); // retorna uma lista de usuários
	}
	
	public Category findById(Long id) {
		Optional<Category> obj =categoryRepository.findById(id); // retorna um objeto do tipo Optional<T>
		return obj.get(); // retorna um objeto de acordo com o tipo preenchido no Generic. No caso, Category.
	}
	
}
