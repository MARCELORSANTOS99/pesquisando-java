package com.marcelo.pesquisando.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pesquisa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cidade;
	
	private String entrevistadoNome;
	private String entrevistadoReligiao;
	private String entrevistadoFaixaIdade;
	private String entrevistadoGenero;
	private String entrevistadoEscolaridade;
	
	private String pergunta;
	
	private String resposta;
	
	
	public Pesquisa() {}
	


	public Pesquisa(Long id, String cidade, String entrevistadoNome, String entrevistadoReligiao,
			String entrevistadoFaixaIdade, String entrevistadoGenero, String entrevistadoEscolaridade, String pergunta,
			String resposta) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.entrevistadoNome = entrevistadoNome;
		this.entrevistadoReligiao = entrevistadoReligiao;
		this.entrevistadoFaixaIdade = entrevistadoFaixaIdade;
		this.entrevistadoGenero = entrevistadoGenero;
		this.entrevistadoEscolaridade = entrevistadoEscolaridade;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	



	public String getEntrevistadoNome() {
		return entrevistadoNome;
	}



	public void setEntrevistadoNome(String entrevistadoNome) {
		this.entrevistadoNome = entrevistadoNome;
	}



	public String getEntrevistadoReligiao() {
		return entrevistadoReligiao;
	}



	public void setEntrevistadoReligiao(String entrevistadoReligiao) {
		this.entrevistadoReligiao = entrevistadoReligiao;
	}



	public String getEntrevistadoFaixaIdade() {
		return entrevistadoFaixaIdade;
	}



	public void setEntrevistadoFaixaIdade(String entrevistadoFaixaIdade) {
		this.entrevistadoFaixaIdade = entrevistadoFaixaIdade;
	}



	public String getEntrevistadoGenero() {
		return entrevistadoGenero;
	}



	public void setEntrevistadoGenero(String entrevistadoGenero) {
		this.entrevistadoGenero = entrevistadoGenero;
	}



	public String getEntrevistadoEscolaridade() {
		return entrevistadoEscolaridade;
	}



	public void setEntrevistadoEscolaridade(String entrevistadoEscolaridade) {
		this.entrevistadoEscolaridade = entrevistadoEscolaridade;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesquisa other = (Pesquisa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}
