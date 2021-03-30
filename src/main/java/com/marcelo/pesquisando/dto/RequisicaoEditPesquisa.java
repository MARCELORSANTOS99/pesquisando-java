package com.marcelo.pesquisando.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;



public class RequisicaoEditPesquisa {
	
	private long nomeId;
		
	private String nomePerguntaEdit;
	
			
	private String nomeResposta;
		
						
	public long getNomeId() {
		return nomeId;
	}
	public void setNomeId(long nomeId) {
		this.nomeId = nomeId;
	}
	public String getNomePergunta() {
		return nomePerguntaEdit;
	}
	public void setNomePergunta(String nomePergunta) {
		this.nomePerguntaEdit = nomePergunta;
	}
	public String getNomeResposta() {
		return nomeResposta;
	}
	public void setNomeResposta(String nomeResposta) {
		this.nomeResposta = nomeResposta;
	}
	
	
	public Pergunta toPesquisa() {
		Pergunta pergunta = new Pergunta();
				
		pergunta.setQuestion("Teste nova Pergunta");
		//pergunta.setRespostas(respostas());
			
		return pergunta;
	}
	
	public List<Resposta> respostas(){
		
		List<Resposta> respostas = new ArrayList<>();
		
		String textoRespostas = nomeResposta;
		String[] arrayRespostas = textoRespostas.split(";");
		
		for (int i = 0; i < arrayRespostas.length; i++) {
			
			Resposta resposta = new Resposta();
			
			resposta.setResp(arrayRespostas[i]);
			respostas.add(resposta);
		
		}
				
		return respostas;
	}

	
	
}
