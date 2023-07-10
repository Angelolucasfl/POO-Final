package com.spotfly.models;

public class Singer extends Artist {

	private String estiloMusical;

	public Singer(String nome, String nacionalidiade, String estiloMusical) {
		super(nome, nacionalidiade);
		this.estiloMusical = estiloMusical;
	}


	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

	
}
