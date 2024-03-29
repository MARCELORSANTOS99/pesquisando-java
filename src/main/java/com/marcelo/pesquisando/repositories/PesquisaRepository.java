package com.marcelo.pesquisando.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.User;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {

	
	
	@Query(value = "SELECT COUNT(p) FROM Pesquisa as p where p.resposta = ?1")
	long resumo(String resposta);
	
	@Query(value = "SELECT COUNT (DISTINCT codigo) FROM Pesquisa as p where p.idCidade = ?1")
	long totalEntrevistadosPorCidade(String idCidade);
	
	@Query(value = "SELECT COUNT (DISTINCT codigo) FROM Pesquisa as p where p.idCidade = ?1 and p.userEmail = ?2")
	long totalEntrevistadosPorFuncionarioCidade(String idCidade, String userEmail);
	
	@Query("SELECT userEmail from Pesquisa u where u.idCidade = ?1 group by u.userEmail")
	public List<String> listaUsuariosPorCidade(String idCidade);
	
	@Query(value = "SELECT p FROM Pesquisa p where idCidade = ?1 ORDER BY id")
	public List<Pesquisa> findAllByIdCidade(String idCidade);
	
	public List<Pesquisa> findAllByOrderByIdAsc();
	
	List<Pesquisa> findByOrderByIdAscCodigoAsc();
	
	@Query(value = "SELECT p FROM Pesquisa p where codigo = ?1")
	List<Pesquisa> findByCodigo(String codigo);
		
	long countByPergunta(String pergunta);
	
	@Query(value = "SELECT entrevistadoBairro FROM Pesquisa where idCidade = ?1 GROUP BY entrevistadoBairro")
	List<String> agruparPorCidadeBairro(String idCidade);
	
	@Query(value = "SELECT respostaDissertiva FROM Pesquisa where idCidade = ?1 GROUP BY respostaDissertiva")
	List<String> agruparPorCidadeEspontanea(String idCidade);
	
	@Query(value = "SELECT entrevistadoBairro FROM Pesquisa where idPergunta = ?1 GROUP BY entrevistadoBairro")
	List<String> agruparPorBairro(long idPergunta);
	
	@Query(value = "SELECT respostaDissertiva FROM Pesquisa where idPergunta = ?1 GROUP BY respostaDissertiva")
	List<String> agruparPorDissertativa(long idPergunta);
	
	@Query(value = "SELECT entrevistadoGenero FROM Pesquisa where idCidade = ?1 GROUP BY entrevistadoGenero")
	List<String> agruparPorGenero(String idCidade);
	
	@Query(value = "SELECT entrevistadoFaixaIdade FROM Pesquisa where idCidade = ?1 GROUP BY entrevistadoFaixaIdade")
	List<String> agruparPorIdade(String idCidade);
	
	@Query(value = "SELECT entrevistadoReligiao FROM Pesquisa where idCidade = ?1 GROUP BY entrevistadoReligiao")
	List<String> agruparPorReligiao(String idCidade);
	
	@Query(value = "SELECT entrevistadoEscolaridade FROM Pesquisa where idCidade = ?1 GROUP BY entrevistadoEscolaridade")
	List<String> agruparPorEscolaridade(String idCidade);

	
	@Query(value = "SELECT COUNT(p) FROM Pesquisa as p where p.pergunta = ?1 AND p.entrevistadoGenero = ?2")
	long resumoApuration(String pergunta, String genero);

	
	@Query(value = "SELECT pergunta,resposta, COUNT(resposta) FROM Pesquisa GROUP BY resposta,pergunta ORDER BY pergunta ")
	public List<String> resumoGrouByPergunta();
	
	@Query(value = "SELECT codigo,latitude,longitude,userEmail,entrevistadoNome FROM Pesquisa as p where p.idCidade = ?1 GROUP BY codigo,latitude,longitude,userEmail,entrevistadoNome")
	public List<String> latLong(String idCidade);

	
	@Query(value = "SELECT COUNT(pergunta) FROM Pesquisa as p where p.pergunta = ?1")
	long resumoApurationPergunta(String pergunta);
	
	
	
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND resposta = ?2")
	public Integer resumoApurationPorRespostaDaPergunta(long idPergunta, String resposta);


	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1")
	public Integer resumoApurationPorRespostaDaPergunta(long idPergunta);
	
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.respostaValida = true")
	public Integer resumoApurationPorRespostaValidaDaPergunta(long idPergunta);
		
	@Query(value = "SELECT COUNT (respostaDissertiva) FROM Pesquisa as p where p.idPergunta = ?1 AND respostaDissertiva = ?2")
	public Integer resumoApurationPorDissertativaDaPergunta(long idPergunta, String dissertativa);
	
	@Query(value = "SELECT COUNT (entrevistadoBairro) FROM Pesquisa as p where p.idPergunta = ?1 AND entrevistadoBairro = ?2")
	public Integer resumoApurationPorBairroDaPergunta(long idPergunta, String bairro);
		
	
	//por genero
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.resposta = ?2 AND p.entrevistadoGenero = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaGenero(long idPergunta, String resposta, String entrevistadoGenero);
	
	//por faixa de idade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND resposta = ?2 AND entrevistadoFaixaIdade = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaIdade(long idPergunta, String resposta, String entrevistadoFaixaIdade);
	
	//por religião
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND resposta = ?2 AND entrevistadoReligiao = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaReligiao(long idPergunta, String resposta, String entrevistadoReligiao );
	
	//por escolaridade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND resposta = ?2 AND entrevistadoEscolaridade = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaEscolaridade(long idPergunta, String resposta, String entrevistadoEscolaridade );
	

	//TIPO - por genero
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.entrevistadoGenero = ?2")
	public Integer resumoApurationPorPerguntaAndTipoGenero(long idPergunta, String entrevistadoGenero);
	
	//TIPO - por idade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.entrevistadoFaixaIdade = ?2")
	public Integer resumoApurationPorPerguntaAndTipoFaixaIdade(long idPergunta, String entrevistadoFaixaIdade);
	
	//TIPO - por religião
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.entrevistadoReligiao = ?2")
	public Integer resumoApurationPorPerguntaAndTipoReligiao(long idPergunta, String entrevistadoReligiao);
	
	//TIPO - por escolaridade
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.entrevistadoEscolaridade = ?2")
	public Integer resumoApurationPorPerguntaAndTipoEscolaridade(long idPergunta, String entrevistadoEscolaridade);
	
	
	//TOTAL PERGUNTA E BAIRRO
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND p.entrevistadoBairro = ?2")
	public Integer resumoApurationPorPerguntaAndBairro(long idPergunta, String entrevistadoBairro);
	
	//TOTAL RESPOSTAS POR PERGUNTA E BAIRRO
	@Query(value = "SELECT COUNT (resposta) FROM Pesquisa as p where p.idPergunta = ?1 AND resposta = ?2 AND entrevistadoBairro = ?3")
	public Integer resumoApurationPorRespostaDaPerguntaBairro(long idPergunta, String resposta, String entrevistadoBairro );
	
	//TOTAL PESQUISAS FEITAS POR USUARIO
	
	@Query(value = "SELECT COUNT (DISTINCT codigo) FROM Pesquisa as p where p.idCidade = ?1 and p.userEmail = ?2 and p.gravado = 'Sim'")
	Integer totalEntrevistasGravadas(String idCidade, String userEmail);
	
	//@Query(value = "SELECT p.codigo, p.usuarioApp COUNT (usuarioApp) FROM Pesquisa as p where p.usuarioApp = ?1 GROUP BY codigo", nativeQuery=true)
    //@Query("SELECT u.serverName,count(u) as controlRunCount from RunList u where u.controlRunDate < :lastUploadDate group by u.serverName")
    @Query("SELECT u.codigo,count(u) as userEmail from Pesquisa u where u.userEmail = ?1 and u.idCidade = ?2 group by u.codigo")
	public List<Object[]> totalPesquisaPorUsuario(String username,String idCidade);
	
    @Query("SELECT u.codigo,count(u) as userEmail from Pesquisa u where u.userEmail = ?1 and u.idCidade = ?2 and u.entrevistadoGenero = ?3 group by u.codigo")
	public List<Object[]> totalPesquisaPorUsuarioGenero(String username,String idCidade, String genero);
	
    @Query("SELECT u.codigo,count(u) as userEmail from Pesquisa u where u.userEmail = ?1 and u.idCidade = ?2 and u.entrevistadoFaixaIdade = ?3 group by u.codigo")
	public List<Object[]> totalPesquisaPorUsuarioIdade(String username,String idCidade, String idade);
	
    @Query("SELECT u.codigo,count(u) as userEmail from Pesquisa u where u.userEmail = ?1 and u.idCidade = ?2 and u.entrevistadoReligiao = ?3 group by u.codigo")
	public List<Object[]> totalPesquisaPorUsuarioReligiao(String username,String idCidade, String idade);
	
    @Query("SELECT u.codigo,count(u) as userEmail from Pesquisa u where u.userEmail = ?1 and u.idCidade = ?2 and u.entrevistadoEscolaridade = ?3 group by u.codigo")
	public List<Object[]> totalPesquisaPorUsuarioEscolaridade(String username,String idCidade, String idade);
	
	@Query("SELECT u.codigo,count(u) as userEmail from Pesquisa u where u.userEmail = ?1 and u.idCidade = ?2 and u.entrevistadoBairro = ?3 group by u.codigo")
	public List<Object[]> totalPesquisaPorUsuarioBairro(String username,String idCidade, String idade);
    

    @Transactional
 	@Modifying
    @Query("UPDATE Pesquisa c SET c.respostaDissertiva = :respostaDissertiva,c.entrevistadoBairro = :entrevistadoBairro WHERE c.id = :id")
    int updateRespostaDissertativa(@Param("id") long id, @Param("respostaDissertiva") String respostaDissertiva, @Param("entrevistadoBairro") String entrevistadoBairro);
    
    @Transactional
 	@Modifying
    @Query("UPDATE Pesquisa c SET c.entrevistadoBairro = :entrevistadoBairroNew WHERE c.idCidade = :id AND c.entrevistadoBairro = :entrevistadoBairroOld ")
    int updateAllBairro(@Param("id") String id, @Param("entrevistadoBairroNew") String entrevistadoBairroNew, @Param("entrevistadoBairroOld") String entrevistadoBairroOld);
    
    @Transactional
 	@Modifying
    @Query("UPDATE Pesquisa c SET c.respostaDissertiva = :entrevistadoEspontaneaNew WHERE c.idCidade = :id AND c.respostaDissertiva = :entrevistadoEspontaneaOld ")
    int updateAllEspontanea(@Param("id") String id, @Param("entrevistadoEspontaneaNew") String entrevistadoEspontaneaNew, @Param("entrevistadoEspontaneaOld") String entrevistadoEspontaneaOld);

    
    

	


	
	

}
