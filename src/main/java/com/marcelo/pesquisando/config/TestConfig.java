package com.marcelo.pesquisando.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.repositories.PerguntaRepository;
import com.marcelo.pesquisando.repositories.RespostaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private RespostaRepository respostaRepository;

	@Autowired
	private PerguntaRepository perguntaRepository;

	@Override
	public void run(String... args) throws Exception {

		Pergunta perg1 = new Pergunta(null, "Em que vc vai votar?");
		Pergunta perg2 = new Pergunta(null, "Você é a favor do porte de arma?");

		Resposta r1 = new Resposta(null, "Cajuru", perg1);
		Resposta r2 = new Resposta(null, "Bolsonaro", perg1);
		Resposta r3 = new Resposta(null, "LULA", perg1);
		Resposta r4 = new Resposta(null, "Sim", perg2);
		Resposta r5 = new Resposta(null, "Não", perg2);

		perguntaRepository.saveAll(Arrays.asList(perg2, perg1));
		respostaRepository.saveAll(Arrays.asList(r1, r2, r3, r4,r5));

	}

}
