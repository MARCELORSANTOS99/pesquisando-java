package com.marcelo.pesquisando.entities;

import java.util.List;

public class RespostaApuracao {
	
	private String pergunta;
	private List<String> tipo;	
	private List<String> respostas;
	private String resposta;
	private List<Integer> totalPorRespostaTipo;
	private Integer totalPerguntaResposta;
	

	public RespostaApuracao(String pergunta, List<String> tipo, List<String> respostas, String resposta,
			List<Integer> totalPorRespostaTipo, Integer totalPerguntaResposta) {
		super();
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.respostas = respostas;
		this.resposta = resposta;
		this.totalPorRespostaTipo = totalPorRespostaTipo;
		this.totalPerguntaResposta = totalPerguntaResposta;
	}


	public String getPergunta() {
		return pergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}


	public List<String> getTipo() {
		return tipo;
	}


	public void setTipo(List<String> tipo) {
		this.tipo = tipo;
	}


	public List<String> getRespostas() {
		return respostas;
	}


	public void setRespostas(List<String> respostas) {
		this.respostas = respostas;
	}


	public String getResposta() {
		return resposta;
	}


	public void setResposta(String resposta) {
		this.resposta = resposta;
	}


	public List<Integer> getTotalPorRespostaTipo() {
		return totalPorRespostaTipo;
	}


	public void setTotalPorRespostaTipo(List<Integer> totalPorRespostaTipo) {
		this.totalPorRespostaTipo = totalPorRespostaTipo;
	}


	public Integer getTotalPerguntaResposta() {
		return totalPerguntaResposta;
	}


	public void setTotalPerguntaResposta(Integer totalPerguntaResposta) {
		this.totalPerguntaResposta = totalPerguntaResposta;
	}


	

		
	
	
	

}
