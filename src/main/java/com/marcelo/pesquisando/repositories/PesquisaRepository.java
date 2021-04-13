package com.marcelo.pesquisando.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.pesquisando.entities.Pesquisa;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
	
	
	
	@Query(value = "SELECT COUNT(p) FROM Pesquisa as p where p.resposta = ?1")
	long resumo(String resposta);
	

	public List<Pesquisa> findAllByOrderByIdAsc();
	
	List<Pesquisa> findByOrderByIdAscCodigoAsc();



	

}
