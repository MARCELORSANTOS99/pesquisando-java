package com.marcelo.pesquisando.entities;

public class LatLongPesquisa {
	
	String codigo;
	String latitude;
	String longitude;
	String usuario;
	String entrevistado;
	Integer numeroCor;
	
	
	public LatLongPesquisa(String codigo,String latitude, String longitude, String usuario, String entrevistado, Integer numeroCor) {
		super();
		this.codigo = codigo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.usuario = usuario;
		this.entrevistado = entrevistado;
		this.numeroCor = numeroCor;
	}
	
		
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEntrevistado() {
		return entrevistado;
	}
	public void setEntrevistado(String entrevistado) {
		this.entrevistado = entrevistado;
	}

	public Integer getNumeroCor() {
		return numeroCor;
	}

	public void setNumeroCor(Integer numeroCor) {
		this.numeroCor = numeroCor;
	}
	
	
	
		
	
	
	
}
