package com.caiomiranda.webservice.configurations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caiomiranda.webservice.entities.Order;
import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.entities.enums.OrderStatus;
import com.caiomiranda.webservice.repositories.OrderRepository;
import com.caiomiranda.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

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

		this.userRepository.saveAll(user);
		this.orderRepository.saveAll(orders);

	}

}
