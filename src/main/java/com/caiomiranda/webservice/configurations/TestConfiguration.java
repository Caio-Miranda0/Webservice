package com.caiomiranda.webservice.configurations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caiomiranda.webservice.entities.Category;
import com.caiomiranda.webservice.entities.Order;
import com.caiomiranda.webservice.entities.Product;
import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.entities.enums.OrderStatus;
import com.caiomiranda.webservice.repositories.CategoryRepository;
import com.caiomiranda.webservice.repositories.OrderRepository;
import com.caiomiranda.webservice.repositories.ProductRepository;
import com.caiomiranda.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		List<User> user = new ArrayList<>();
		user.add(new User(null, "Caio", "caio@gmail.com", "62999990000", "abc123"));
		user.add(new User(null, "Letícia", "leticia@gmail.com", "21999991111", "asdf1234"));
		user.add(new User(null, "Jéssica", "jessica@gmail.com", "71978670000", "aaws23"));

		List<Order> orders = new ArrayList<>();
		orders.add(new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user.get(0)));
		orders.add(new Order(null, Instant.now(), OrderStatus.PAID, user.get(2)));
		orders.add(new Order(null, Instant.now(), OrderStatus.CANCELED, user.get(0)));
		orders.add(new Order(null, Instant.now(), OrderStatus.DELIVERED, user.get(1)));
		orders.add(new Order(null, Instant.now(), OrderStatus.PAID, user.get(2)));
		orders.add(new Order(null, Instant.now(), OrderStatus.SHIPPED, user.get(1)));

		userRepository.saveAll(user);
		orderRepository.saveAll(orders);

		List<Category> categories = new ArrayList<>();
		categories.add(new Category(null, "Livros"));
		categories.add(new Category(null, "Brinquedos"));
		categories.add(new Category(null, "Eletrônicos"));
		categories.add(new Category(null, "Ferramentas"));

		categoryRepository.saveAll(categories);

		List<Product> products = new ArrayList<>();
		products.add(new Product(null, "Bola de futebol", "Objeto para jogar futebol", 35.90, "url/bola"));
		products.add(new Product(null, "Microondas", "Eletrodoméstico para fazer comida", 350.90, "url/microondas"));
		products.add(new Product(null, "Furadeira", "Ferramenta de construção civil", 300.0, "url/furadeira"));
		products.add(new Product(null, "O Hobbit", "Livro de literatura ingles", 50.0, "url/livroHobbit"));
		
		products.get(0).getCategories().add(categories.get(1)); // Bola id 1 é um brinquedo id 2
		products.get(1).getCategories().add(categories.get(2)); // Microondas id 2 é um eletrônico id 3
		products.get(2).getCategories().add(categories.get(2)); // Furadeira id 3 é um eletronico id 3
		products.get(2).getCategories().add(categories.get(3)); // Furadeira id 3 é uma ferramenta id 4
		products.get(3).getCategories().add(categories.get(0)); // O hobbit id 4 é um livro id 1

		productRepository.saveAll(products);

	}

}
