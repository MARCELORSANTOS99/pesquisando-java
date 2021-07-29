package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.User;

public interface AuthoritiesRepository extends JpaRepository<User, String> {

	
	User findByUsername(String username);

	


}
