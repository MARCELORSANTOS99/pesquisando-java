package com.marcelo.pesquisando.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	
	
    public List<Resposta> findAllByOrderByIdAsc();



   
}
