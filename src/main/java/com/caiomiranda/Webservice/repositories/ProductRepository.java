package com.caiomiranda.Webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiomiranda.Webservice.entities.Product;

// Interface responsável pelo CRUD.
public interface ProductRepository extends JpaRepository<Product, Long> {

}
