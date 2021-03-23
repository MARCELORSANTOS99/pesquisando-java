package com.marcelo.pesquisando.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.marcelo.pesquisando.entities.enums.EntrevistadoEscolaridade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoFaixaIdade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoGenero;
import com.marcelo.pesquisando.entities.enums.EntrevistadoReligiao;

@Entity
@Table(name = "tb_entrevistado")
public class Entrevistado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private EntrevistadoReligiao entrevistadoReligiao;
	private EntrevistadoFaixaIdade faixaIdade;
	private EntrevistadoGenero genero;
	private EntrevistadoEscolaridade escolaridade;
	
	public Entrevistado() {
		
	}
	
	
	public Entrevistado(Long id, String nome, EntrevistadoReligiao entrevistadoReligiao,
			EntrevistadoFaixaIdade faixaIdade, EntrevistadoGenero genero, EntrevistadoEscolaridade escolaridade) {
		super();
		this.id = id;
		this.nome = nome;
		this.entrevistadoReligiao = entrevistadoReligiao;
		this.faixaIdade = faixaIdade;
		this.genero = genero;
		this.escolaridade = escolaridade;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EntrevistadoReligiao getEntrevistadoReligiao() {
		return entrevistadoReligiao;
	}

	public void setEntrevistadoReligiao(EntrevistadoReligiao entrevistadoReligiao) {
		this.entrevistadoReligiao = entrevistadoReligiao;
	}
	
	
	

	public EntrevistadoFaixaIdade getFaixaIdade() {
		return faixaIdade;
	}

	public void setFaixaIdade(EntrevistadoFaixaIdade faixaIdade) {
		this.faixaIdade = faixaIdade;
	}

	public EntrevistadoGenero getGenero() {
		return genero;
	}

	public void setGenero(EntrevistadoGenero genero) {
		this.genero = genero;
	}

	public EntrevistadoEscolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EntrevistadoEscolaridade escolaridade) {
		this.escolaridade = escolaridade;
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
		Entrevistado other = (Entrevistado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
		
	
	
	
	

}
