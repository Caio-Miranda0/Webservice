package com.caiomiranda.Webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiomiranda.Webservice.entities.Order;
import com.caiomiranda.Webservice.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired // Injeta a dependência
	private OrderService orderService;

	@GetMapping // Response a requisões do tipo GET.
	public ResponseEntity<List<Order>> findAll() {
		List<Order> order = orderService.findAll();
		return ResponseEntity.ok().body(order);
	}

	@GetMapping(value = "/{id}") // Response a requisões do tipo GET com passagem de parâmetro.
	public ResponseEntity<Order> findById(@PathVariable Long id) { // Usa o parâmetro da request como argumento do método findById.
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
