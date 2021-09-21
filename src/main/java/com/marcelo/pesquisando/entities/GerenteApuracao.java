package com.marcelo.pesquisando.entities;

public class GerenteApuracao {
	
	String nome;
	String email;
	Integer totalPesquisaFeitasUser;
	Integer totalPesquisaFeitasUserGravadas;
	
	
	public GerenteApuracao(String nome, String email, Integer totalPesquisaFeitasUser,  Integer totalPesquisaFeitasUserGravadas) {
		super();
		this.nome = nome;
		this.email = email;
		this.totalPesquisaFeitasUser = totalPesquisaFeitasUser;
		this.totalPesquisaFeitasUserGravadas = totalPesquisaFeitasUserGravadas;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		

	public Integer getTotalPesquisaFeitasUserGravadas() {
		return totalPesquisaFeitasUserGravadas;
	}

	public void setTotalPesquisaFeitasUserGravadas(Integer totalPesquisaFeitasUserGravadas) {
		this.totalPesquisaFeitasUserGravadas = totalPesquisaFeitasUserGravadas;
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
