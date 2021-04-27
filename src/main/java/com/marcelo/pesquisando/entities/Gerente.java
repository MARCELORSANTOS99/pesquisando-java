package com.marcelo.pesquisando.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gerente")
public class Gerente {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String userFirebase;
	private Boolean manager;
	
		
	public Boolean getManager() {
		return manager;
	}
	public void setManager(Boolean manager) {
		this.manager = manager;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserFirebase() {
		return userFirebase;
	}
	public void setUserFirebase(String userFirebase) {
		this.userFirebase = userFirebase;
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
		Gerente other = (Gerente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
