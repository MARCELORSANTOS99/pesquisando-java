package com.marcelo.pesquisando.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pergunta")
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;
	

	@OneToMany(mappedBy="pergunt")
	private List<Resposta> respostas = new ArrayList<>();
	
		
	public Pergunta() {}


	public Pergunta(Long id, String question, String dissertativa) {
		super();
		this.id = id;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}


	public List<String> getRespostasWeb() {
		
		System.out.println("***ENTROU PARA RECUPERAR RESPOSTAS***");
		
		List<String> respostasWeb = new ArrayList<>();
		
		for (int i = 0; i < getRespostas().size(); i++) {
			long idPerg = getId();
			long idResp = getRespostas().get(i).getPergunt().getId();
			/*
			System.out.println("getQuestion = "+ getQuestion());
			System.out.println("idPerg = "+ idPerg);
			System.out.println("idResp = "+ idResp);
			*/
			if (idPerg == idResp) {
				respostasWeb.add(getRespostas().get(i).getResp());
				//System.out.println("getRespostas = "+ getRespostas().get(i).getResp());
			}
		}
		
				
		return respostasWeb;
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
		Pergunta other = (Pergunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}