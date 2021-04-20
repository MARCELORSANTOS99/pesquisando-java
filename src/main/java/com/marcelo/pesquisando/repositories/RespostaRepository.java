package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.pesquisando.entities.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	

   
}
