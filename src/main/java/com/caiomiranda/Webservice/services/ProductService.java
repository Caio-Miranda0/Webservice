package com.caiomiranda.Webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiomiranda.Webservice.entities.Product;
import com.caiomiranda.Webservice.repositories.ProductRepository;

@Service // Registro semântico de um componente Spring
public class ProductService {
	
	@Autowired // Faz a injeção da dependência
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll(); // retorna uma lista de usuários
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id); // retorna um objeto do tipo Optional<T>
		return obj.get(); // retorna um objeto de acordo com o tipo preenchido no Generic. No caso, Product.
	}
	
}
