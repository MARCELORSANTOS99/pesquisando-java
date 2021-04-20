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
	
	long countByPergunta(String pergunta);
	
	
	
	@Query(value = "SELECT COUNT(p) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoGenero = ?2")
	long resumoApuration(String pergunta, String genero);
	
	
	
	@Query(value = "SELECT pergunta,resposta, COUNT(resposta) FROM Pesquisa GROUP BY resposta,pergunta ORDER BY pergunta ")
	public List<String> resumoGrouByPergunta();

	
	// and p.genero = ?2 , String genero
	
	
	//@Query("select count(*) from Example ex where ex.id = ?1 and ex.status in (?2)")
	//long countByIdAndStatus(Integer id, List<Type> params);

}
