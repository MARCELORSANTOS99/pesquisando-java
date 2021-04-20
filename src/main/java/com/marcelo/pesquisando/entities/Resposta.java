package com.marcelo.pesquisando.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_resposta")
public class Resposta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String resp;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pergunt_id")
	private Pergunta pergunt;

	public Resposta() {}
	
	public Resposta(Long id, String resp, Pergunta pergunt) {
		super();
		this.id = id;
		this.resp = resp;
		this.pergunt = pergunt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getResp() {
		return resp;
	}



	public void setResp(String resp) {
		this.resp = resp;
	}



	public Pergunta getPergunt() {
		
		return pergunt;
	}



	public void setPergunt(Pergunta pergunt) {
		this.pergunt = pergunt;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}