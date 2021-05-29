package com.marcelo.pesquisando.entities;

public class GerenteApuracao {
	
	String uid;
	String nome;
	String email;
	Integer totalPesquisaFeitasUser;
	
	
	public GerenteApuracao(String uid, String nome, String email, Integer totalPesquisaFeitasUser) {
		super();
		this.uid = uid;
		this.nome = nome;
		this.email = email;
		this.totalPesquisaFeitasUser = totalPesquisaFeitasUser;
	}

	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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


	public Integer getTotalPesquisaFeitasUser() {
		return totalPesquisaFeitasUser;
	}
	public void setTotalPesquisaFeitasUser(Integer totalPesquisaFeitasUser) {
		this.totalPesquisaFeitasUser = totalPesquisaFeitasUser;
	}
	
	
	
	
}
