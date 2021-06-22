package com.marcelo.pesquisando.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contrato")
public class Contrato implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String nomeResponsavel;
	private String email;
	private String telefone;
	private String cnpj;
	private String endereco;
	private String logo;
	private Date inicioContrato;
	private Boolean status;
	private String tipoContrato;
	private Integer qtdCidades;
	
	@OneToMany(mappedBy="contract")
	private List<Cidade> cidades = new ArrayList<>();
	
		
	public Contrato() {
	
	}
	public Contrato(long id, String nome, String nomeResponsavel, String email, String telefone, String cnpj,
			String endereco, String logo, Date inicioContrato, Boolean status, String tipoContrato, Integer qtdCidades,
			List<Cidade> cidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeResponsavel = nomeResponsavel;
		this.email = email;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.logo = logo;
		this.inicioContrato = inicioContrato;
		this.status = status;
		this.tipoContrato = tipoContrato;
		this.qtdCidades = qtdCidades;
		this.cidades = cidades;
	
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
	
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getInicioContrato() {
		return inicioContrato;
	}
	public void setInicioContrato(Date inicioContrato) {
		this.inicioContrato = inicioContrato;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public Integer getQtdCidades() {
		return qtdCidades;
	}
	public void setQtdCidades(Integer qtdCidades) {
		this.qtdCidades = qtdCidades;
	}
		
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
		Contrato other = (Contrato) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
