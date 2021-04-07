package com.marcelo.pesquisando.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Entrevistado;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.entities.enums.EntrevistadoEscolaridade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoFaixaIdade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoGenero;
import com.marcelo.pesquisando.entities.enums.EntrevistadoReligiao;
import com.marcelo.pesquisando.repositories.CidadeRepository;
import com.marcelo.pesquisando.repositories.EntrevistadoRepository;
import com.marcelo.pesquisando.repositories.PerguntaRepository;
import com.marcelo.pesquisando.repositories.PesquisaRepository;
import com.marcelo.pesquisando.repositories.RespostaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private RespostaRepository respostaRepository;

	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Autowired
	private EntrevistadoRepository entrevistadoRepository;
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {

		
		
		Entrevistado p1 = new Entrevistado(null,"Marcelo Santos",EntrevistadoReligiao.OUTRA,EntrevistadoFaixaIdade.DE_26_A_40_ANOS,EntrevistadoGenero.HOMEM,EntrevistadoEscolaridade.SUPERIOR_COMPLETO);
		Entrevistado p2 = new Entrevistado(null,"Debora Santos",EntrevistadoReligiao.ESPIRITA,EntrevistadoFaixaIdade.DE_26_A_40_ANOS,EntrevistadoGenero.MULHER,EntrevistadoEscolaridade.SUPERIOR_COMPLETO);
		Entrevistado p3 = new Entrevistado(null,"Alice",EntrevistadoReligiao.ESPIRITA,EntrevistadoFaixaIdade.ATE_18_ANOS,EntrevistadoGenero.MULHER,EntrevistadoEscolaridade.PRIMEIRO_GRAU_COMPLETO);

		Pergunta perg1 = new Pergunta(null, "Em que vc vai votar?",null);
		Pergunta perg2 = new Pergunta(null, "Você é a favor do porte de arma?","Não gosto de arma");

		Resposta r1 = new Resposta(null, "Cajuru", perg1);
		Resposta r2 = new Resposta(null, "Bolsonaro", perg1);
		Resposta r3 = new Resposta(null, "LULA", perg1);
		Resposta r4 = new Resposta(null, "Sim", perg2);
		Resposta r5 = new Resposta(null, "Não", perg2);
		
		Cidade city = new Cidade();
		city.setNome("Salvador");
		
		ArrayList<Pergunta> perguntas = new ArrayList<>();
		perguntas.add(perg1);
		perguntas.add(perg2);
		
		
		//Montar pesquisa
		Pesquisa pesquisa = new Pesquisa();
		Pesquisa pesquisa2 = new Pesquisa();
		Pesquisa pesquisa3 = new Pesquisa();
		Pesquisa pesquisa4 = new Pesquisa();
		
		//cidade
		pesquisa.setCidade("Três Pontas");
		pesquisa2.setCidade("Três Pontas");
		pesquisa3.setCidade("Três Pontas");
		pesquisa4.setCidade("Três Pontas");
		
		//Entrevistado
		pesquisa.setEntrevistadoNome(p1.getNome());
		pesquisa.setEntrevistadoEscolaridade(p1.getEscolaridade().toString());
		pesquisa.setEntrevistadoFaixaIdade(p1.getFaixaIdade().toString());
		pesquisa.setEntrevistadoGenero(p1.getGenero().toString());
		pesquisa.setEntrevistadoReligiao(p1.getEntrevistadoReligiao().toString());
		
		pesquisa2.setEntrevistadoNome(p2.getNome());
		pesquisa2.setEntrevistadoEscolaridade(p2.getEscolaridade().toString());
		pesquisa2.setEntrevistadoFaixaIdade(p2.getFaixaIdade().toString());
		pesquisa2.setEntrevistadoGenero(p2.getGenero().toString());
		pesquisa2.setEntrevistadoReligiao(p2.getEntrevistadoReligiao().toString());
		
		pesquisa3.setEntrevistadoNome(p3.getNome());
		pesquisa3.setEntrevistadoEscolaridade(p3.getEscolaridade().toString());
		pesquisa3.setEntrevistadoFaixaIdade(p3.getFaixaIdade().toString());
		pesquisa3.setEntrevistadoGenero(p3.getGenero().toString());
		pesquisa3.setEntrevistadoReligiao(p3.getEntrevistadoReligiao().toString());
		
		pesquisa4.setEntrevistadoNome(p3.getNome());
		pesquisa4.setEntrevistadoEscolaridade(p3.getEscolaridade().toString());
		pesquisa4.setEntrevistadoFaixaIdade(p3.getFaixaIdade().toString());
		pesquisa4.setEntrevistadoGenero(p3.getGenero().toString());
		pesquisa4.setEntrevistadoReligiao(p3.getEntrevistadoReligiao().toString());
		
		//Pergunta
		pesquisa.setPergunta(perg1.getQuestion());
		pesquisa2.setPergunta(perg1.getQuestion());
		pesquisa3.setPergunta(perg1.getQuestion());
		pesquisa4.setPergunta(perg2.getQuestion());
		
			
		
		//Resposta escolhida
		pesquisa.setResposta("Bolsonaro");
		pesquisa2.setResposta("Bolsonaro");
		pesquisa3.setResposta("LULA");
		pesquisa4.setResposta("Não");
		
		//Observaçãosss
		pesquisa4.setRespostaDissertiva("Não gosto de armas");
		
		
		
		entrevistadoRepository.saveAll(Arrays.asList(p1,p2));
		perguntaRepository.saveAll(Arrays.asList(perg2, perg1));
		respostaRepository.saveAll(Arrays.asList(r1, r2, r3, r4,r5));
		pesquisaRepository.saveAll(Arrays.asList(pesquisa,pesquisa2,pesquisa3,pesquisa4));
		cidadeRepository.saveAll(Arrays.asList(city));


	}

}
