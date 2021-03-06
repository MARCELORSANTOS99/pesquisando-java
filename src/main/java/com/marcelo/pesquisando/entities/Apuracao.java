package com.marcelo.pesquisando.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_apuracao")
public class Apuracao implements Serializable {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String pergunta;
	private String resposta;
	private int qtd;
	private String dissertativa;
	
	
	
	public Apuracao(String pergunta, String resposta, int qtd, String dissertativa) {
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.qtd = qtd;
		this.dissertativa = dissertativa;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
			
	public String getDissertativa() {
		return dissertativa;
	}


	public void setDissertativa(String dissertativa) {
		this.dissertativa = dissertativa;
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
		Apuracao other = (Apuracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
private static final long serialVersionUID = 1L;	
	

}
