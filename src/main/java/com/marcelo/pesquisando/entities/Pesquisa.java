package com.marcelo.pesquisando.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy HH:mm", locale = "pt-BR", timezone = "Brazil/East")
	private Instant moment = Instant.now();
	
	private String codigo;
	
	private String cidade;
	
	private String entrevistadoNome;
	private String entrevistadoBairro;
	private String entrevistadoRua;
	private String entrevistadoNumero;
	private String entrevistadoReligiao;
	private String entrevistadoFaixaIdade;
	private String entrevistadoGenero;
	private String entrevistadoEscolaridade;
	private String pergunta;
	private String resposta;
	private String respostaDissertiva;
	private String usuarioApp;
	
	
	public Pesquisa() {}
	


	public Pesquisa(Long id, Instant moment, String codigo, String cidade, String entrevistadoNome,
			String entrevistadoBairro, String entrevistadoRua, String entrevistadoNumero, String entrevistadoReligiao,
			String entrevistadoFaixaIdade, String entrevistadoGenero, String entrevistadoEscolaridade, String pergunta,
			String resposta, String respostaDissertiva, String user) {
		super();
		this.id = id;
		this.moment = moment;
		this.codigo = codigo;
		this.cidade = cidade;
		this.entrevistadoNome = entrevistadoNome;
		this.entrevistadoBairro = entrevistadoBairro;
		this.entrevistadoRua = entrevistadoRua;
		this.entrevistadoNumero = entrevistadoNumero;
		this.entrevistadoReligiao = entrevistadoReligiao;
		this.entrevistadoFaixaIdade = entrevistadoFaixaIdade;
		this.entrevistadoGenero = entrevistadoGenero;
		this.entrevistadoEscolaridade = entrevistadoEscolaridade;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.respostaDissertiva = respostaDissertiva;
		this.usuarioApp = user;
	}

	


	public String getUsuarioApp() {
		return usuarioApp;
	}



	public void setUsuarioApp(String usuarioApp) {
		this.usuarioApp = usuarioApp;
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



	public Instant getMoment() {
		
		return moment;
	}



	public void setMoment(Instant moment) {
		this.moment = moment;
	}



	public String getEntrevistadoBairro() {
		return entrevistadoBairro;
	}



	public void setEntrevistadoBairro(String entrevistadoBairro) {
		this.entrevistadoBairro = entrevistadoBairro;
	}



	public String getEntrevistadoRua() {
		return entrevistadoRua;
	}



	public void setEntrevistadoRua(String entrevistadoRua) {
		this.entrevistadoRua = entrevistadoRua;
	}



	public String getEntrevistadoNumero() {
		return entrevistadoNumero;
	}



	public void setEntrevistadoNumero(String entrevistadoNumero) {
		this.entrevistadoNumero = entrevistadoNumero;
	}
	
	

	

}
