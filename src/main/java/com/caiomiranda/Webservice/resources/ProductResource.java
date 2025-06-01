package com.caiomiranda.Webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiomiranda.Webservice.entities.Product;
import com.caiomiranda.Webservice.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired // Injeta a dependência
	private ProductService productService;

	@GetMapping // Response a requisões do tipo GET.
	public ResponseEntity<List<Product>> findAll() {
		List<Product> Product = productService.findAll();
		return ResponseEntity.ok().body(Product);
	}

	@GetMapping(value = "/{id}") // Response a requisões do tipo GET com passagem de parâmetro.
	public ResponseEntity<Product> findById(@PathVariable Long id) { // Usa o parâmetro da request como argumento do método findById.
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
