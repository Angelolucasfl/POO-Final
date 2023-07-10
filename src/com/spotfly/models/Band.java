package com.spotfly.models;

public class Band extends Artist {
	
	private String estiloMusical;

	public Band(String nome, String nacionalidiade, String estiloMusical, int numIntegrantes) {
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
