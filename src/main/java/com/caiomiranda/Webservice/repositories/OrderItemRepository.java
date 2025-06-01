package com.caiomiranda.Webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiomiranda.Webservice.entities.OrderItem;
import com.caiomiranda.Webservice.entities.pk.OrderItemPK;

// Interface responsável pelo CRUD.
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
