package com.marcelo.pesquisando.dto;

import com.marcelo.pesquisando.entities.Cidade;

public class RequisicaoNovaCidade {
	
	private long nomeId;
	private String nomeCidade;
	private String nomeCodigo;
	
	public long getNomeId() {
		return nomeId;
	}
	public void setNomeId(long nomeId) {
		this.nomeId = nomeId;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public Cidade toCidade() {
		Cidade cidade = new Cidade();
		cidade.setNome(nomeCidade);
	
			
		return cidade;
	}
	
	

}
