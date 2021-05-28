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
	
	@Query(value = "SELECT entrevistadoBairro FROM Pesquisa where pergunta = ?1 GROUP BY entrevistadoBairro")
	List<String> agruparPorBairro(String pergunta);
	
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
	
	@Query(value = "SELECT COUNT (entrevistadoBairro) FROM Pesquisa as p where p.pergunta = ?1 AND entrevistadoBairro = ?2")
	public Integer resumoApurationPorBairroDaPergunta(String question, String bairro);
	
	
	
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
	

	//TIPO - por genero
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoGenero = ?2")
	public Integer resumoApurationPorPerguntaAndTipoGenero(String pergunta, String entrevistadoGenero);
	
	//TIPO - por idade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoFaixaIdade = ?2")
	public Integer resumoApurationPorPerguntaAndTipoFaixaIdade(String pergunta, String entrevistadoFaixaIdade);
	
	//TIPO - por religião
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoReligiao = ?2")
	public Integer resumoApurationPorPerguntaAndTipoReligiao(String pergunta, String entrevistadoReligiao);
	
	//TIPO - por escolaridade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoEscolaridade = ?2")
	public Integer resumoApurationPorPerguntaAndTipoEscolaridade(String pergunta, String entrevistadoEscolaridade);
	
	
	//TOTAL PERGUNTA E BAIRRO
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoBairro = ?2")
	public Integer resumoApurationPorPerguntaAndBairro(String pergunta, String entrevistadoBairro);
	
	//TOTAL RESPOSTAS POR PERGUNTA E BAIRRO
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.pergunta = ?1 AND resposta = ?2 AND entrevistadoBairro = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaBairro(String pergunta, String resposta, String entrevistadoBairro );
	

    @Transactional
 	@Modifying
    @Query("UPDATE Pesquisa c SET c.respostaDissertiva = :respostaDissertiva,c.entrevistadoBairro = :entrevistadoBairro WHERE c.id = :id")
    int updateRespostaDissertativa(@Param("id") long id, @Param("respostaDissertiva") String respostaDissertiva, @Param("entrevistadoBairro") String entrevistadoBairro);


	
	

}
