package com.caiomiranda.Webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiomiranda.Webservice.entities.Category;
import com.caiomiranda.Webservice.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired // Injeta a dependência
	private CategoryService categoryService;

	@GetMapping // Response a requisões do tipo GET.
	public ResponseEntity<List<Category>> findAll() {
		List<Category> Category = categoryService.findAll();
		return ResponseEntity.ok().body(Category);
	}

	@GetMapping(value = "/{id}") // Response a requisões do tipo GET com passagem de parâmetro.
	public ResponseEntity<Category> findById(@PathVariable Long id) { // Usa o parâmetro da request como argumento do método findById.
		Category obj = categoryService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
