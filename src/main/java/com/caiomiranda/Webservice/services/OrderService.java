package com.caiomiranda.Webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiomiranda.Webservice.entities.Order;
import com.caiomiranda.Webservice.repositories.OrderRepository;

@Service // Registro semântico de um componente Spring
public class OrderService {
	
	@Autowired // Faz a injeção da dependência
	private OrderRepository OrderRepository;
	
	public List<Order> findAll() {
		return OrderRepository.findAll(); // retorna uma lista de usuários
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = OrderRepository.findById(id); // retorna um objeto do tipo Optional<T>
		return obj.get(); // retorna um objeto de acordo com o tipo preenchido no Generic. No caso, Order.
	}
	
}
