package com.caiomiranda.Webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiomiranda.Webservice.entities.Order;

// Interface responsável pelo CRUD.
public interface OrderRepository extends JpaRepository<Order, Long> {

}
