package com.marcelo.pesquisando.entities;

import java.util.List;

public class TipoApuracao {
	
	private String pergunta;//
	private String tipo;//
	private String tipoResposta;//
	private List<String> respostas;//
	private List<Integer> totalPorRespostaTipo;
	private Integer totalPerguntaTipo;
	
	



	public TipoApuracao(String pergunta, String tipo, String tipoResposta, List<String> respostas,
			List<Integer> totalPorRespostaTipo, Integer totalPerguntaTipo) {
		super();
		this.pergunta = pergunta;
		this.tipo = tipo;
		this.tipoResposta = tipoResposta;
		this.respostas = respostas;
		this.totalPorRespostaTipo = totalPorRespostaTipo;
		this.totalPerguntaTipo = totalPerguntaTipo;
	}


	public String getPergunta() {
		return pergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<String> getRespostas() {
		return respostas;
	}


	public void setRespostas(List<String> respostas) {
		this.respostas = respostas;
	}


	public List<Integer> getTotalPorRespostaTipo() {
		return totalPorRespostaTipo;
	}


	public void setTotalPorRespostaTipo(List<Integer> totalPorRespostaTipo) {
		this.totalPorRespostaTipo = totalPorRespostaTipo;
	}


	public Integer getTotalPerguntaTipo() {
		return totalPerguntaTipo;
	}


	public void setTotalPerguntaTipo(Integer totalPerguntaTipo) {
		this.totalPerguntaTipo = totalPerguntaTipo;
	}


	public String getTipoResposta() {
		return tipoResposta;
	}


	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta;
	}
	
	
	
	
	
	

}
