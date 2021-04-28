package com.marcelo.pesquisando.entities;

import java.util.List;

public class PerguntaApuracao {
	
	private String pergunta;
	private List<String> respostas;
	private List<Integer> totalPorResposta;
	private Integer totalPorPergunta;
	private List<String> respostasDissertativa;
	private List<Integer> totalRespostasDissertativa;
	
	public String getPergunta() {
		return pergunta;
	}
	
		
	public PerguntaApuracao(String pergunta, List<String> respostas, List<Integer> totalPorResposta, Integer totalPorPergunta, List<String> respostasDissertativa, List<Integer> totalRespostasDissertativa ) {
		super();
		this.pergunta = pergunta;
		this.respostas = respostas;
		this.totalPorResposta = totalPorResposta;
		this.totalPorPergunta = totalPorPergunta;
		this.respostasDissertativa = respostasDissertativa;
		this.totalRespostasDissertativa = totalRespostasDissertativa;
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


	public List<String> getRespostasDissertativa() {
		return respostasDissertativa;
	}


	public void setRespostasDissertativa(List<String> respostasDissertativa) {
		this.respostasDissertativa = respostasDissertativa;
	}


	public List<Integer> getTotalRespostasDissertativa() {
		return totalRespostasDissertativa;
	}


	public void setTotalRespostasDissertativa(List<Integer> totalRespostasDissertativa) {
		this.totalRespostasDissertativa = totalRespostasDissertativa;
	}
	
	
	
	

}
