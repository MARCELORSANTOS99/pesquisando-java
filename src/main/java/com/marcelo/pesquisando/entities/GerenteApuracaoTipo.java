package com.marcelo.pesquisando.entities;

public class GerenteApuracaoTipo {
	
	String tipo;
	Integer totalPesquisaFeitasUserTipo;
	
		
	public GerenteApuracaoTipo(String tipo, Integer totalPesquisaFeitasUserTipo) {
		super();
		this.tipo = tipo;
		this.totalPesquisaFeitasUserTipo = totalPesquisaFeitasUserTipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getTotalPesquisaFeitasUserTipo() {
		return totalPesquisaFeitasUserTipo;
	}
	public void setTotalPesquisaFeitasUserTipo(Integer totalPesquisaFeitasUserTipo) {
		this.totalPesquisaFeitasUserTipo = totalPesquisaFeitasUserTipo;
	}
	
	

	
	
}
