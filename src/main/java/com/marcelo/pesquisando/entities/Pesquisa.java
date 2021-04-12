package com.marcelo.pesquisando.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pesquisa")
public class Pesquisa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//@JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", locale = "pt-BR", timezone = "Brazil/East")
	private Instant moment = Instant.now();
	
	private String codigo;
	
	private String cidade;
	
	private String entrevistadoNome;
	private String entrevistadoReligiao;
	private String entrevistadoFaixaIdade;
	private String entrevistadoGenero;
	private String entrevistadoEscolaridade;
	
	private String pergunta;
	
	private String resposta;
	
	private String respostaDissertiva;
	
	
	public Pesquisa() {}
	


	public Pesquisa(Long id, String codigo, String cidade, String entrevistadoNome, String entrevistadoReligiao,
			String entrevistadoFaixaIdade, String entrevistadoGenero, String entrevistadoEscolaridade, String pergunta,
			String resposta, String respostaDissertiva) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cidade = cidade;
		this.entrevistadoNome = entrevistadoNome;
		this.entrevistadoReligiao = entrevistadoReligiao;
		this.entrevistadoFaixaIdade = entrevistadoFaixaIdade;
		this.entrevistadoGenero = entrevistadoGenero;
		this.entrevistadoEscolaridade = entrevistadoEscolaridade;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.resposta = respostaDissertiva;
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
	

	public String getRespostaDissertiva() {
		return respostaDissertiva;
	}



	public void setRespostaDissertiva(String respostaDissertiva) {
		this.respostaDissertiva = respostaDissertiva;
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



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
	

}
