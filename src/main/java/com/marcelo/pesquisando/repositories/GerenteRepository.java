package com.marcelo.pesquisando.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
	
	
	
	Optional<Gerente> findByUserFirebase(String userFirebase);


}
