package com.marcelo.pesquisando.entities;

import java.util.List;

public class PerguntaApuracao {
	
	private String pergunta;
	private long idPergunta;
	private String respEspontanea;
	private List<String> respostas;
	private List<Integer> totalPorResposta;
	private Integer totalPorPergunta;
	private List<String> respostasDissertativa;
	private List<Integer> totalRespostasDissertativa;
	private List<String> respostasBairro;
	private List<Integer> totalRespostasBairro;
	private List<String> respostasValida;
	private List<Integer> totalRespostasValida;
	private Integer totalPorPerguntaRespostaValida;
	
	
	public String getPergunta() {
		return pergunta;
	}
	




	public PerguntaApuracao(String pergunta, long idPergunta, String respEspontanea, List<String> respostas,
			List<Integer> totalPorResposta, Integer totalPorPergunta, List<String> respostasDissertativa,
			List<Integer> totalRespostasDissertativa, List<String> respostasBairro, List<Integer> totalRespostasBairro,
			List<String> respostasValida, List<Integer> totalRespostasValida, Integer totalPorPerguntaRespostaValida) {
		super();
		this.pergunta = pergunta;
		this.idPergunta = idPergunta;
		this.respEspontanea = respEspontanea;
		this.respostas = respostas;
		this.totalPorResposta = totalPorResposta;
		this.totalPorPergunta = totalPorPergunta;
		this.respostasDissertativa = respostasDissertativa;
		this.totalRespostasDissertativa = totalRespostasDissertativa;
		this.respostasBairro = respostasBairro;
		this.totalRespostasBairro = totalRespostasBairro;
		this.respostasValida = respostasValida;
		this.totalRespostasValida = totalRespostasValida;
		this.totalPorPerguntaRespostaValida = totalPorPerguntaRespostaValida;
	}





	public Integer getTotalPorPergunta() {
		return totalPorPergunta;
	}
	
	
	public long getIdPergunta() {
		return idPergunta;
	}


	public void setIdPergunta(long idPergunta) {
		this.idPergunta = idPergunta;
	}


	public void setTotalPorPergunta(Integer totalPorPergunta) {
		this.totalPorPergunta = totalPorPergunta;
	}
	
	
	public String getRespEspontanea() {
		return respEspontanea;
	}

	public void setRespEspontanea(String respEspontanea) {
		this.respEspontanea = respEspontanea;
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


	public List<String> getRespostasBairro() {
		return respostasBairro;
	}


	public void setRespostasBairro(List<String> respostasBairro) {
		this.respostasBairro = respostasBairro;
	}


	public List<Integer> getTotalRespostasBairro() {
		return totalRespostasBairro;
	}


	public void setTotalRespostasBairro(List<Integer> totalRespostasBairro) {
		this.totalRespostasBairro = totalRespostasBairro;
	}





	public List<String> getRespostasValida() {
		return respostasValida;
	}





	public void setRespostasValida(List<String> respostasValida) {
		this.respostasValida = respostasValida;
	}





	public List<Integer> getTotalRespostasValida() {
		return totalRespostasValida;
	}





	public void setTotalRespostasValida(List<Integer> totalRespostasValida) {
		this.totalRespostasValida = totalRespostasValida;
	}





	public Integer getTotalPorPerguntaRespostaValida() {
		return totalPorPerguntaRespostaValida;
	}





	public void setTotalPorPerguntaRespostaValida(Integer totalPorPerguntaRespostaValida) {
		this.totalPorPerguntaRespostaValida = totalPorPerguntaRespostaValida;
	}
	
	
	
	

}
