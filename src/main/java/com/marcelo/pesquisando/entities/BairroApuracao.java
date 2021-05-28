package com.marcelo.pesquisando.entities;

import java.util.List;

public class BairroApuracao {
	
	private String pergunta;//
	private String bairro;//
	private List<String> respostas;//
	private List<Integer> totalPorRespostaTipo;
	private Integer totalPerguntaTipo;
	
	

	public BairroApuracao(String pergunta, String bairro, List<String> respostas,
			List<Integer> totalPorRespostaTipo, Integer totalPerguntaTipo) {
		super();
		this.pergunta = pergunta;
		this.bairro = bairro;
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





	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	
	
	
	
	
	

}
