package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Apuracao;

public interface ApuracaoRepository extends JpaRepository<Apuracao, Long> {
	
	

}
