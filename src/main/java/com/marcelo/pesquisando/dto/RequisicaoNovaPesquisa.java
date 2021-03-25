package com.marcelo.pesquisando.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;

public class RequisicaoNovaPesquisa {
	
	private String nomeCidade;
	private String nomePergunta;
	private String nomeResposta;
	
	
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getNomePergunta() {
		return nomePergunta;
	}
	public void setNomePergunta(String nomePergunta) {
		this.nomePergunta = nomePergunta;
	}
	public String getNomeResposta() {
		return nomeResposta;
	}
	public void setNomeResposta(String nomeResposta) {
		this.nomeResposta = nomeResposta;
	}
	public Pergunta toPesquisa() {
		Pergunta pergunta = new Pergunta();
				
		pergunta.setQuestion(nomePergunta);
		pergunta.setRespostas(respostas());
		
		return pergunta;
	}
	
	public List<Resposta> respostas(){
		
		List<Resposta> respostas = new ArrayList<>();
		
		String textoRespostas = nomeResposta;
		String[] arrayRespostas = textoRespostas.split(";");
		System.out.println("textoRespostas: "+ textoRespostas);
        System.out.println(arrayRespostas[0]);
        System.out.println(arrayRespostas[1]);
        System.out.println("tamanho: " + arrayRespostas.length);
		

        
        
		for (int i = 0; i < arrayRespostas.length; i++) {
			
			Resposta resposta = new Resposta();
			
			resposta.setResp(arrayRespostas[i]);
			respostas.add(resposta);
		
		}
				
		return respostas;
	}

	
	
}
