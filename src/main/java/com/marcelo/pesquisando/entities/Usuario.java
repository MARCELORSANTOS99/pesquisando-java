package com.marcelo.pesquisando.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String uid;
	private Boolean gerente;
	private Integer corMarker;
	private Instant lastLogin;

	
	@ManyToOne
	@JoinColumn(name="contract_id")
	private Contrato contract;
	


	public Usuario() {
		
	}




	public Usuario(long id, String nome, String email, String uid, Boolean gerente, Contrato contract, Integer corMarker,Instant lastLogin) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.uid = uid;
		this.gerente = gerente;
		this.contract = contract;
		this.corMarker = corMarker;
		this.lastLogin = lastLogin;
	}



	public Contrato getContract() {
		return contract;
	}


	public void setContract(Contrato contract) {
		this.contract = contract;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGerente() {
		return gerente;
	}

	public void setGerente(Boolean gerente) {
		this.gerente = gerente;
	}
	
	



	public String getUid() {
		return uid;
	}




	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	public Integer getCorMarker() {
		return corMarker;
	}


	public void setCorMarker(Integer corMarker) {
		this.corMarker = corMarker;
	}
	


	public Instant getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Instant lastLogin) {
		this.lastLogin = lastLogin;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	

}
