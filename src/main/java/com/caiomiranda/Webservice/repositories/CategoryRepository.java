package com.caiomiranda.Webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiomiranda.Webservice.entities.Category;

// Interface responsável pelo CRUD.
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
