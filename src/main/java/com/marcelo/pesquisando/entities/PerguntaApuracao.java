package com.marcelo.pesquisando.entities;

import java.util.List;

public class PerguntaApuracao {
	
	private String pergunta;
	private List<String> respostas;
	private List<Integer> totalPorResposta;
	private Integer totalPorPergunta;
	
	public String getPergunta() {
		return pergunta;
	}
	
		
	public PerguntaApuracao(String pergunta, List<String> respostas, List<Integer> totalPorResposta, Integer totalPorPergunta ) {
		super();
		this.pergunta = pergunta;
		this.respostas = respostas;
		this.totalPorResposta = totalPorResposta;
		this.totalPorPergunta = totalPorPergunta;
	}



	public Integer getTotalPorPergunta() {
		return totalPorPergunta;
	}


	public void setTotalPorPergunta(Integer totalPorPergunta) {
		this.totalPorPergunta = totalPorPergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public List<String> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<String> respostas) {
		this.respostas = respostas;
	}
	public List<Integer> getTotalPorResposta() {
		return totalPorResposta;
	}
	public void setTotalPorResposta(List<Integer> totalPorResposta) {
		this.totalPorResposta = totalPorResposta;
	}
	
	
	
	

}
