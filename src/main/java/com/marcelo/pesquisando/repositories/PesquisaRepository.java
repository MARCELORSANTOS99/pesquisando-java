package com.marcelo.pesquisando.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Resposta;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
	
	
	
	@Query(value = "SELECT COUNT(p) FROM Pesquisa as p where p.resposta = ?1")
	long resumo(String resposta);
	
		
	public List<Pesquisa> findAllByOrderByIdAsc();
	
	List<Pesquisa> findByOrderByIdAscCodigoAsc();
	
	long countByPergunta(String pergunta);
	
	@Query(value = "SELECT respostaDissertiva FROM Pesquisa where pergunta = ?1 GROUP BY respostaDissertiva")
	List<String> agruparPorDissertativa(String pergunta);

	
	@Query(value = "SELECT COUNT(p) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoGenero = ?2")
	long resumoApuration(String pergunta, String genero);
	

	
	@Query(value = "SELECT pergunta,resposta, COUNT(resposta) FROM Pesquisa GROUP BY resposta,pergunta ORDER BY pergunta ")
	public List<String> resumoGrouByPergunta();

	
	@Query(value = "SELECT COUNT(pergunta) FROM Pesquisa as p where p.pergunta = ?1")
	long resumoApurationPergunta(String pergunta);
	
	
	
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND resposta = ?2")
	public Integer resumoApurationPorRespostaDaPergunta(String pergunta, String resposta);



	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1")
	public Integer resumoApurationPorRespostaDaPergunta(String question);
	
	@Query(value = "SELECT COUNT (respostaDissertiva) FROM Pesquisa as p where p.pergunta = ?1 AND respostaDissertiva = ?2")
	public Integer resumoApurationPorDissertativaDaPergunta(String question, String dissertativa);
	
	
	//por genero
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND p.resposta = ?2 AND p.entrevistadoGenero = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaGenero(String pergunta, String resposta, String entrevistadoGenero);
	
	//por faixa de idade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND resposta = ?2 AND entrevistadoFaixaIdade = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaIdade(String pergunta, String resposta, String entrevistadoFaixaIdade);
	
	//por religião
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND resposta = ?2 AND entrevistadoReligiao = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaReligiao(String pergunta, String resposta, String entrevistadoReligiao );
	
	//por escolaridade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND resposta = ?2 AND entrevistadoEscolaridade = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaEscolaridade(String pergunta, String resposta, String entrevistadoEscolaridade );

	
    @Transactional
 	@Modifying
    @Query("UPDATE Pesquisa c SET c.respostaDissertiva = :respostaDissertiva WHERE c.id = :id")
    int updateRespostaDissertativa(@Param("id") long id, @Param("respostaDissertiva") String respostaDissertiva);


	
	

}
