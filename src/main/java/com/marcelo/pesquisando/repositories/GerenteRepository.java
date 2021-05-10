package com.marcelo.pesquisando.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.pesquisando.entities.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
		
	Optional<Gerente> findByUserFirebase(String userFirebase);
	
	
	@Query(value = "SELECT nome FROM Gerente where userFirebase = ?1")
	public String pegarUser(String uid);

}
