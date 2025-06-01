package com.caiomiranda.Webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiomiranda.Webservice.entities.User;

// Interface responsável pelo CRUD.
public interface UserRepository extends JpaRepository<User, Long> {

}
